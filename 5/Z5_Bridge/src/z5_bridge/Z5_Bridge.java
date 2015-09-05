/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z5_bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ja
 */
public class Z5_Bridge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonsSource dbsrc = new PersonsSource() {
            @Override
            public Collection<Person> getPersons() {
                // connect to database
                // blah blah
                Person p = new Person();
                List<Person> l = new ArrayList<>();
                l.add(p);
                return l;
            }
        };
        PersonRegistry reg = new PersonRegistryMailNotifiable(dbsrc);
        reg.NotifyPersons();
    }
    
}
