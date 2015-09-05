/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z5_bridge2;

/**
 *
 * @author ja
 */
public class PersonRegistryFromXML extends PersonRegistry {

    public PersonRegistryFromXML(MethodOfNotification mon, XML xml) {
        super(mon);
        retrievePersons(xml);
    }
    
    private void retrievePersons(XML xml) {
        // initialize _persons list ...
    }

    private class XML {

        public XML() {
        }
    }
    
}
