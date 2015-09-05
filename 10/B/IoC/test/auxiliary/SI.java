/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auxiliary;

import ioc.DependencyProperty;

/**
 *
 * @author ja
 */
public class SI {
    
    
    private A a;
    
    @DependencyProperty
    public void ASetter(A aa) { a = aa; }
    
    public A AGetter() { return a; }
    
    public SI () { }
}
