/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singletons;


/**
 * 
 * @author ja
 */
public class SingletonWithTimeout {
    private static final long _timeoutMs = 1000; // in milliseconds
    private static long _lastCreation = System.currentTimeMillis();
    private static boolean _firstCreated = false;
    
    private SingletonWithTimeout() {
        
    }
    
    public static SingletonWithTimeout getInstance() throws InstantiationException {
        long current = System.currentTimeMillis();
        if(_firstCreated && current - _lastCreation < _timeoutMs) {
            throw new InstantiationException("You still have to wait " + 
                    (new Long(_timeoutMs - current + _lastCreation)).toString() + " miliseconds");
        }
        SingletonWithTimeout s = new SingletonWithTimeout();
        _firstCreated = true;
        _lastCreation = System.currentTimeMillis();
        return s;
    }
}
