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
public class OneAnnotated {
    
    private boolean annotetedChosen = false;
    
    public boolean wasAnnotatedChosen() { return annotetedChosen; }
    
    @DependencyConstructor
    public OneAnnotated() {annotetedChosen = true; }
    
    public OneAnnotated(int a, int b, int c) { }
    
}
