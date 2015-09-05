/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package state_z4;

import java.util.Set;

/**
 *
 * @author ja
 */
public class VendingMachine implements IVendingMachine {
    IState state;
    public int credit;
    public VMProduct chosenProduct;
    public Set<VMProduct> availableProducts;
    
    public VendingMachine(Set<VMProduct> p) {
        availableProducts = p;
        credit = 0;
        setState(new VMUnset()); 
    }
    
    public void setState(IState s) {
        state = s;
    }
    public IState getState() {
        return state;
    }

    @Override
    public void pickProduct(VMProduct p) {
        if(availableProducts.contains(p))
            state.pickProduct(this, p);
    }

    @Override
    public void putMoney(int amount) {
        state.putMoney(this, amount);
    }

    @Override
    public boolean buy() {
        return state.buy(this);
    }

    @Override
    public int giveChange() {
        System.out.println("Giving " + credit + " of change");
        int aux = credit;
        credit = 0;
        return aux;
    }
    
    public void dispose() {
        System.out.println("Disposing " + chosenProduct);
    }

    @Override
    public Set<VMProduct> showProducts() {
        return availableProducts;
    }
}
