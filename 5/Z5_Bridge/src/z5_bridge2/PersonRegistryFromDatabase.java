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
public class PersonRegistryFromDatabase extends PersonRegistry {

    public PersonRegistryFromDatabase(MethodOfNotification mon, Database db) {
        super(mon);
        retrievePersons(db);
    }
    
    private void retrievePersons(Database db) {
        // initialize _persons list ...
    }

    private class Database {

        public Database() {
        }
    }
    
}