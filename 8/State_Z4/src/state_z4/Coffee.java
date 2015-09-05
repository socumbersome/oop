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
public class Coffee extends VMProduct {

    @Override
    public int getPrice() {
        return 4;
    }
    
    public String toString() {
        return "Coffee";
    }
    
    public int hashCode() {
        return 1;
    }
    
}
