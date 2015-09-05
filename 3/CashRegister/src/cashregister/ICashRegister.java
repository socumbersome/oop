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
public interface ICashRegister {
    public BigDecimal CalculatePrice(Item[] Items);
    public String PrintBill(Item[] Items);
    public void setTaxCalculator(ITaxCalculator calc);
}
