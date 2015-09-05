/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja
 */
public class UsersDatabase {
    public List<Person> students, lecturers;
    
    public UsersDatabase() {
        students = new ArrayList<>();
        lecturers = new ArrayList<>();
        
    }
    
    public void addStudent(Person p) {
        students.add(p);
    }
    
    public void addLecturer(Person p) {
        lecturers.add(p);
    }
}
