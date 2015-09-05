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
public class Dummy {
    
    private static int a = 0;
    public int count = 0;
    
    public Dummy() {
        a++;
        count = a;
    }
    
}
