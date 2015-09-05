/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

import javax.swing.AbstractListModel;

/**
 *
 * @author ja
 */
public class UsersListModel extends AbstractListModel implements ISubscriber {

    @Override
    public void handle(MyEventType notification) {
        if(notification instanceof Category) {
            Category c = (Category)notification;
            if(c.desc().equals("students"))
                smode = SecondaryMode.STUDENTS;
            else
                smode = SecondaryMode.LECTURERS;
            System.out.println("change to " + c.desc());
            pmode = PrimaryMode.EVERYONE;
            eaggregator.publish(new RefreshUI());
            
        }
        else if(notification instanceof Persona) {
            Persona p = (Persona)notification;
            pmode = PrimaryMode.DETAILS;
            chosenIfDetails = Integer.valueOf(p.desc());
            System.out.println("id = " + chosenIfDetails);
            eaggregator.publish(new RefreshUI());
            
        }
    }
    
    private enum SecondaryMode {
        STUDENTS, LECTURERS;
    }
    
    private enum PrimaryMode {
        EVERYONE, DETAILS;
    }
    
    private PrimaryMode pmode = PrimaryMode.EVERYONE;
    private SecondaryMode smode = SecondaryMode.STUDENTS;
    
    public int chosenIfDetails = 0;
    
    private UsersDatabase users;
    EventAggregator eaggregator;
    public UsersListModel(UsersDatabase users, EventAggregator eaggregator) {
        this.users = users;
        this.eaggregator = eaggregator;
    }
    
    @Override
    public int getSize() {
        if(pmode == PrimaryMode.DETAILS)
            return 1;
        if(smode == SecondaryMode.STUDENTS)
            return users.students.size();
        else
            return users.lecturers.size();
    }

    @Override
    public Object getElementAt(int i) {
        if(pmode == PrimaryMode.DETAILS) {
            if(smode == SecondaryMode.LECTURERS) {
                Person p = users.lecturers.get(chosenIfDetails);
                return toPresentation(p) + " " + p.additional;
            }
            else {
                Person p = users.students.get(chosenIfDetails);
                return toPresentation(p) + " " + p.additional;
            }
        }
        else {
            if(smode == SecondaryMode.LECTURERS)
                return toPresentation(users.lecturers.get(i));
            else
                return toPresentation(users.students.get(i));
        }
    }
    
    public String toPresentation(Person p) {
        return p.surname + "    " + p.name + "    " + p.dateOfBirth + "    " + p.address;
    }
    
}
