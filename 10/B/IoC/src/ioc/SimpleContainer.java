/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc;

import ioc.utils.RootedTree;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ja
 */
public class SimpleContainer {
    
    protected Map< Class<?>, Class<?> > registeredTypesFromTo;
    protected Set< Class<?> > singletonTypes;
    protected Map< Class<?>, Object > singletons;
    protected Map< Class<?>, Object > instances;
    
    
    public SimpleContainer() {
        registeredTypesFromTo = new HashMap<>();
        singletonTypes = new HashSet<>();
        singletons = new HashMap<>();
        instances = new HashMap<>();
    }
    
    public <T> void RegisterType(Class<T> klass, boolean singleton) {
        RegisterType(klass, klass, singleton);
    }
    
    public <From, To extends From> void RegisterType(
            Class<From> from, Class<To> to, boolean singleton) {
        
        for(Class<?> singletonType : singletonTypes) {
            if(singletonType.isAssignableFrom(to)) {
                throw new RuntimeException("Type " + to + " has a supertype " +
                    singletonType + " that has already been registered as singleton type.");
            }
        }
        
        if(registeredTypesFromTo.containsKey(from)) {
            registeredTypesFromTo.remove(from);
        }
        if(instances.containsKey(from)) {
            instances.remove(from);
        }
        registeredTypesFromTo.put(from, to);
        if(singleton)
            singletonTypes.add(from);
    }
    
    public <T> void RegisterInstance(T instance) {
        
        Class<?> klass = instance.getClass();
        RegisterType(klass, false);
        
        instances.put(klass, instance);
    }
    
    public <T> T Resolve(Class<T> klass) throws Exception {
        
        RootedTree<Class<?> > dependencyTree = 
                (RootedTree<Class<?>>) new RootedTree<>((Class<?>)klass);
        return _Resolve(klass, dependencyTree);
    }
    
    private <T> T _Resolve(
            Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        T resolved = null;
        if(!registeredTypesFromTo.containsKey(klass)) {
            resolved = (T)giveUnregisteredObject(klass, dependencyTree);
        }
        else if(singletonTypes.contains(klass)) {
            resolved = (T)giveSingleton(klass, dependencyTree);
        }
        else {
            resolved = (T)giveRegisteredObject(klass, dependencyTree);
        }

        return resolved;
    }
    
    private <T> Object giveSingleton(
            Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        if(singletons.containsKey(klass)) {
            return singletons.get(klass);
        }
        else {
            Object obj = giveRegisteredObject(klass, dependencyTree);
            singletons.put(klass, obj);
            return obj;
        }
    }
    
    private <T> Object giveUnregisteredObject(
            Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        if(klass.isInterface()) {
            throw new InstantiationException("An interface " + klass +
                " has not been registered.");
        }
        else if(Modifier.isAbstract(klass.getModifiers())) {
            throw new InstantiationException("An abstract class " + klass +
                " has not been registered.");
        }
        else {
            return giveObjectFromClass(klass, dependencyTree);
        }
    }
    
    private <T> Object giveRegisteredObject(
            Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        if(instances.containsKey(klass)) {
            return instances.get(klass);
        }
        else
            return giveObjectFromClass(registeredTypesFromTo.get(klass), dependencyTree);
    }
    
    
    private <T> Constructor<?> chooseConstructor(Class<T> klass) throws Exception {
        
        Constructor<?>[] ctors = klass.getConstructors();
        if(ctors.length == 0)
            throw new InstantiationException("No public constructor found in " + klass);
        
        Constructor<?> chosenCtor = null;
        int nbOfAnnotatedCtors = 0;
        DependencyConstructor depCtorAnnot;
        for(Constructor<?> ctor : ctors) {
            depCtorAnnot = ctor.getAnnotation(DependencyConstructor.class);
            if(depCtorAnnot != null) {
                chosenCtor = ctor;
                nbOfAnnotatedCtors++;
            }
        }
        if(nbOfAnnotatedCtors >= 2)
            throw new InstantiationException("Ambiguity: more than one constructor "
                    + "annotated as DependencyConstructor");
        
        else if(nbOfAnnotatedCtors == 0) { // choose longest one
            chosenCtor = ctors[0];
            int newlen, currlen;
            currlen = chosenCtor.getParameterTypes().length;
            for(Constructor<?> ctor : ctors) {
                newlen = ctor.getParameterTypes().length;
                if(newlen > currlen)
                    chosenCtor = ctor;
            }
        }
        return chosenCtor;
    }
    
    private <T> Object giveObjectFromClass(
            Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        Constructor<?> chosenCtor = chooseConstructor(klass);
        
        Class<?>[] params = chosenCtor.getParameterTypes();
        ArrayList<Object> paramsObjs = new ArrayList();
        RootedTree<Class<?> > currentNode = dependencyTree;
        for(Class<?> parklass : params) {
            if(currentNode.isOnPathToRootInclusive(parklass)) {
                throw new InstantiationException("Infinite dependency tree due to type " + parklass + ".");
            }
            dependencyTree = currentNode.addChild(parklass);
            paramsObjs.add(this._Resolve(parklass, dependencyTree));
        }
        
        T klassObj = (T)chosenCtor.newInstance(paramsObjs.toArray());
        
        injectFields(klassObj, klass, dependencyTree);
        injectPropertiesViaSetters(klassObj, klass, dependencyTree);
        
        return klassObj;
    }
    
    private <T> void injectPropertiesViaSetters(
            T object, Class<?> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        Method[] methods = klass.getMethods();
        DependencyProperty depProp;
        Class<?> propType;
        Object propObj;
        RootedTree<Class<?> > currentNode = dependencyTree;
        
        for(Method method : methods) {
            depProp = method.getAnnotation(DependencyProperty.class);
            if(depProp != null) {
                String methodName = method.getName();
                if(methodName.contains("setter") || methodName.contains("Setter")) {
                    // it's only a heuristic... : (
                    Class<?>[] params = method.getParameterTypes();
                    if(params.length != 1)
                        continue; // a good setter should have exactly one parameter
                    
                    propType = params[0];
                    if(currentNode.isOnPathToRootInclusive(propType)) {
                      throw new InstantiationException("Infinite dependency tree due to type " + propType + ".");
                    }
                    dependencyTree = currentNode.addChild(propType);
                    propObj = this._Resolve(propType, dependencyTree);
                    method.invoke(object, propObj);
                    }
            }
        }
    }
    
    private <T> void injectFields(
            T object, Class<?> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        
        Field[] fields = klass.getFields();
        DependencyField depProp;
        Class<?> propType;
        Object propObj;
        RootedTree<Class<?> > currentNode = dependencyTree;
        
        for(Field field : fields) {
            depProp = field.getAnnotation(DependencyField.class);
            if(depProp != null) {
                propType = field.getType();
                if(currentNode.isOnPathToRootInclusive(propType)) {
                  throw new InstantiationException("Infinite dependency tree due to type " + propType + ".");
                }
                dependencyTree = currentNode.addChild(propType);
                propObj = this._Resolve(propType, dependencyTree);
                field.set(object, propObj);
            }
        }
    }
    
    public <T> void BuildUp(T instance) throws Exception {
        Class<?> klass = instance.getClass();
        
        RootedTree<Class<?> > dependencyTree = 
                (RootedTree<Class<?>>) new RootedTree<>((Class<?>)klass);
        
        
        injectFields(instance, klass, dependencyTree);
        injectPropertiesViaSetters(instance, klass, dependencyTree);
    }
    
}
