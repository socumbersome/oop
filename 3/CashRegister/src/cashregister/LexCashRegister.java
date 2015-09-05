/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cashregister;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author ja
 */
public class LexCashRegister extends CashRegister {
    
    @Override
    public String PrintBill(Item[] Items) {
        
        Arrays.sort(Items, new Comparator<Item>() {

            @Override
            public int compare(Item t, Item t1) {
                return t.Name.compareToIgnoreCase(t1.Name);
            }
            
        });
        
        return super.PrintBill(Items);
    }
}
