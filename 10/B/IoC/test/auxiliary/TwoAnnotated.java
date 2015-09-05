/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auxiliary;

import ioc.DependencyConstructor;

/**
 *
 * @author ja
 */
public class TwoAnnotated {
    
    @DependencyConstructor
    public TwoAnnotated() { }
    
    @DependencyConstructor
    public TwoAnnotated(int x, int y) { }
    
    public TwoAnnotated(int a, int b, int c) { }
    
}
