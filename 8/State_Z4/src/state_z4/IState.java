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
public interface IState {
    
    public void pickProduct(VendingMachine vm, VMProduct p);
    public void putMoney(VendingMachine vm, int amount);
    public boolean buy(VendingMachine vm);
    //public int giveChange(VendingMachine vm);
}
