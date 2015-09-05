/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singletons;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ja
 */
public class SingletonPerThread {
    private static final Map<Long, SingletonPerThread> _instances = 
            Collections.synchronizedMap(new HashMap<Long, SingletonPerThread>());
    //private Map<Long, SingletonPerThread> ii = new HashMap<>();
    private SingletonPerThread() {
        // do stuff, initialize etc.
    }
    
    public synchronized static SingletonPerThread getInstance() {
        Long threadId = Thread.currentThread().getId();
        if(!_instances.containsKey(threadId)) {
            _instances.put(threadId, new SingletonPerThread());
        }
        return _instances.get(threadId);
    }
}
