/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z5_bridge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja
 */
public abstract class PersonRegistry {
    
    protected List<Person> _persons;
    
    public PersonRegistry(PersonsSource s) {
        _persons = new ArrayList(s.getPersons());
    }
    
    public abstract void NotifyPersons();
}
