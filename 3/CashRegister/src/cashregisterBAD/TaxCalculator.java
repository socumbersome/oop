/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cashregisterBAD;

import java.math.BigDecimal;

/**
 *
 * @author ja
 */
public class TaxCalculator {

    public BigDecimal CalculateTax(BigDecimal Price) {
        return Price.multiply(new BigDecimal(0.22));
    }
    
}
