/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.utils;

/**
 *
 * @author ja
 */
public class Pair<T, U> {
    
    public T a;
    public U b;
    
    public Pair() {
        
    }
    
    public void setA(T a) {
        this.a = a;
    }
    
    public void setB(U b) {
        this.b = b;
    }
    
    public Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }
}
