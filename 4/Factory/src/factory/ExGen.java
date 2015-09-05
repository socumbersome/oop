/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

/**
 *
 * @author ja
 * @param <T>
 */
public class ExGen<T> {
    
    public T t;
    public Integer val;
    
    public ExGen(T t, Integer val) {
        this.t = t;
        this.val = val;
    }
}
