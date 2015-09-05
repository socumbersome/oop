/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    
    private Map<Class<?>, Class<?> > 
            registeredTypesFromTo = new HashMap<>();
    private Set<Class<?>> singletonTypes = new HashSet<>();
    private Map<Class<?>, Object> singletons = new HashMap<>();
    private Map<Class<?>, Object> instances = new HashMap<>();
    
    
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
        RootedTree<Class<?> > dependencyTree = (RootedTree<Class<?>>) new RootedTree<>((Class<?>)klass);
        return _Resolve(klass, dependencyTree);
    }
    
    private <T> T _Resolve(Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        T resolved = null;
        if(!registeredTypesFromTo.containsKey(klass)) {
            if(klass.isInterface()) {
                throw new InstantiationException("An interface " + klass +
                    " has not been registered.");
            }
            else if(Modifier.isAbstract(klass.getModifiers())) {
                throw new InstantiationException("An abstract class " + klass +
                    " has not been registered.");
            }
            else {
                resolved = (T)giveObjectFromClass(klass, dependencyTree);
            }
        }
        else if(singletonTypes.contains(klass)) {
            if(singletons.containsKey(klass)) {
                resolved = (T)singletons.get(klass);
            }
            else {
                Object obj = giveRegisteredObject(klass, dependencyTree);
                singletons.put(klass, obj);
                resolved = (T)obj;
            }
        }
        else {
            resolved = (T)giveRegisteredObject(klass, dependencyTree);
        }

        return resolved;
    }
    
    private <T> Object giveRegisteredObject(Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
        if(instances.containsKey(klass)) {
            return instances.get(klass);
        }
        return giveObjectFromClass(registeredTypesFromTo.get(klass), dependencyTree);
    }
    
    private <T> Object giveObjectFromClass(Class<T> klass, RootedTree<Class<?> > dependencyTree) throws Exception {
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
        
        else if(nbOfAnnotatedCtors == 0) {
            chosenCtor = ctors[0];
            int newlen, currlen;
            currlen = chosenCtor.getParameterTypes().length;
            for(Constructor<?> ctor : ctors) {
                newlen = ctor.getParameterTypes().length;
                if(newlen > currlen)
                    chosenCtor = ctor;
            }
        }
        
        assert chosenCtor != null;
        
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
        
        Object klassObj = chosenCtor.newInstance(paramsObjs.toArray());
        return klassObj;
    }
    
}
