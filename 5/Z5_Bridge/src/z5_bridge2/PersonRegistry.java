/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z5_bridge2;

import java.util.List;

/**
 *
 * @author ja
 */
public abstract class PersonRegistry {
    
    protected List<Person> _persons;
    MethodOfNotification mon;
    
    public PersonRegistry(MethodOfNotification mon) {
        this.mon = mon;
    }
    
    public void NotifyPersons() {
        for(Person p : _persons)
            mon.Notify(p);
    }
}