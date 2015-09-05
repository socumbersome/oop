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
public class Person {
    public String surname, name, dateOfBirth, address, additional;
    
    public Person(String name, String surname, String dateOfBirth, String address, String additional) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.additional = additional;
    }
    
    @Override
    public String toString() {
        return name + " " + surname;
    }
}
