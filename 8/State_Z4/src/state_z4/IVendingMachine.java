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
public interface IVendingMachine {
    
    public void pickProduct(VMProduct p);
    public void putMoney(int amount);
    public boolean buy();
    public int giveChange();
    public Set<VMProduct> showProducts();
    
}
