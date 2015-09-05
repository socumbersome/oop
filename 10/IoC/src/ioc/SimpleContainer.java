/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    
    public <T> void RegisterType(Class<T> klass, boolean singleton) {
        RegisterType(klass, klass, singleton);
    }
    
    public <From, To extends From> void RegisterType(
            Class<From> from, Class<To> to, boolean singleton) {
        if(registeredTypesFromTo.containsKey(from)) {
            if(singletonTypes.contains(from))
                return; // cheating forbidden
            registeredTypesFromTo.remove(from);
        }
        registeredTypesFromTo.put(from, to);
        if(singleton)
            singletonTypes.add(from);
    }
    
    public <T> T Resolve(Class<T> klass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        if(!registeredTypesFromTo.containsKey(klass))
            throw new InstantiationException("Type " + klass +
                " has not been registered.");
        if(singletonTypes.contains(klass)) {
            if(singletons.containsKey(klass)) {
                return (T)singletons.get(klass);
            }
            else {
                Object obj = giveObject(klass);
                singletons.put(klass, obj);
                return (T)obj;
            }
        }
        else {
            Object obj = giveObject(klass);
            return (T)obj;
        }
    }
    
    private <T> Object giveObject(Class<T> klass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?> ctor = registeredTypesFromTo.get(klass).getConstructor();
        return ctor.newInstance();
    }
    
}
