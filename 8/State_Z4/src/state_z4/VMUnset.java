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
public class VMUnset extends VMAbstractState {

    @Override
    public void pickProduct(VendingMachine vm, VMProduct p) {
        vm.chosenProduct = p;
        vm.setState(new VMProductChosen());
    }
    
    @Override
    public boolean buy(VendingMachine vm) {
        return false;
    }
    
    public String toString() {
        return "VMUnset";
    }
    
}
