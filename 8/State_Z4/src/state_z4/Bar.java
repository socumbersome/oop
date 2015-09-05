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
public class Bar extends VMProduct {

    @Override
    public int getPrice() {
        return 2;
    }
    
    public String toString() {
        return "Bar";
    }
    
    public int hashCode() {
        return 1;
    }
    
}
