/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package state_z4;

/**
 *
 * @author ja
 */
public abstract class VMProduct {
    
    public abstract int getPrice();
    
    @Override
    public boolean equals(Object o) {
        if(! (o instanceof VMProduct))
            return false;
        VMProduct oo = (VMProduct)o;
        return this.toString().equals(oo.toString());
    }
    
}
