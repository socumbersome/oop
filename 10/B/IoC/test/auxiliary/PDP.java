/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auxiliary;

import ioc.DependencyField;
import ioc.DependencyProperty;

/**
 *
 * @author ja
 */
public class PDP {
            
    @DependencyField
    public TB dpub;
    
    @DependencyField
    private TB dpriv;
    
    public TB pub;

    public boolean isDprivNull() { return dpriv == null; }
    
    public PDP () { }

};
