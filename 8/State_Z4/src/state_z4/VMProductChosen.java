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
public class VMProductChosen extends VMAbstractState {

    @Override
    public void pickProduct(VendingMachine vm, VMProduct p) {
        vm.chosenProduct = p;
    }

    @Override
    public boolean buy(VendingMachine vm) {
        if(vm.credit >= vm.chosenProduct.getPrice()) {
            vm.credit -= vm.chosenProduct.getPrice();
            vm.dispose();
            vm.giveChange();
            vm.setState(new VMUnset());
            return true;
        }
        else {
            // nothing changes
            return false;
        }
    }
    
    public String toString() {
        return "VMProductChosen";
    }
}
