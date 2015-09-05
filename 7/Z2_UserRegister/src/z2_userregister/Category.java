/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

/**
 *
 * @author ja
 */
public class Category implements MyEventType {

    public Category(String c) {
        this.c = c;
    }
    
    private String c;
    @Override
    public String desc() {
        return c;
    }

}
