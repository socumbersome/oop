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
public abstract class VMAbstractState implements IState {
    
    @Override
    public void putMoney(VendingMachine vm, int amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Negative amount of money has been put");
        vm.credit += amount;
    }
    
    @Override
    public boolean equals(Object o) {
        if(! (o instanceof VMAbstractState))
            return false;
        VMAbstractState oo = (VMAbstractState)o;
        return this.toString().equals(oo.toString());
    }
}
