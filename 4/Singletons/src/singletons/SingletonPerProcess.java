/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singletons;

/**
 * Lazy singleton version
 * @author ja
 */
public class SingletonPerProcess {
    private static SingletonPerProcess _instance = null;

    private SingletonPerProcess() {
        // do stuff, initialize etc.
    }
    
    public static SingletonPerProcess getInstance() {
        if(_instance == null) {
            _instance = new SingletonPerProcess();
        }
        return _instance;
    }
    
}
