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
public class CashRegister implements ICashRegister {

    public ITaxCalculator taxCalc = new TaxCalculator();
    
    @Override
    public BigDecimal CalculatePrice(Item[] Items) {
        BigDecimal _price = new BigDecimal(0);
        for(Item item : Items) {
            _price = _price.add( 
                        item.Price.add(
                        taxCalc.CalculateTax(item.Price)
                                      )
                                );
        }
        return _price;
    }

    @Override
    public String PrintBill(Item[] Items) {
        for(Item item : Items) {
            System.out.format(
                    "towar %s : cena %3f + podatek %3f\n",
                    item.Name, item.Price,
                    taxCalc.CalculateTax(item.Price));
        }
        return ""; // why String as a return type? o_O
    }

    @Override
    public void setTaxCalculator(ITaxCalculator calc) {
        taxCalc = calc;
    }
    
}
