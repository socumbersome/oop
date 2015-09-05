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
public class Persona implements MyEventType {
    public Persona(int id) {
        this.id = id;
    }
    private int id;

    @Override
    public String desc() {
        return String.valueOf(id);
    }
    
}
