/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z5_bridge;


/**
 *
 * @author ja
 */
public class PersonRegistryMailNotifiable extends PersonRegistry {
    
    public PersonRegistryMailNotifiable(PersonsSource s) {
        super(s);
    }
    
    @Override
    public void NotifyPersons()
    {
        for(Person person : _persons) {
            System.out.println(person);
            System.out.println(" notified by mail");
        }
    }
}
