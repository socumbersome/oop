/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cashregister;

import java.math.BigDecimal;

/**
 *
 * @author ja
 */
public class Item {
    public BigDecimal Price;
    public String Name;
    
    public Item(double x, String s) {
        Price = new BigDecimal(x);
        Name = s;
    }
}
