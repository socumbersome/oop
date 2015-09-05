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
public class Villa extends VMProduct {

    @Override
    public int getPrice() {
        return 1234567890;
    }
    
    public String toString() {
        return "Villa";
    }
    
    public int hashCode() {
        return 1;
    }
    
}
