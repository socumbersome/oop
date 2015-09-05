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
public class Z2_UserRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final UsersDatabase db = new UsersDatabase();
        db.addLecturer(new Person("john", "kowalsky", "02.03.1999", "Boston", "ads"));
        db.addLecturer(new Person("ala", "makota", "11.11.1990", "Wies", "aisd"));
        db.addStudent(new Person("meg", "peg", "02.03.1988", "Moscow", "aids"));
        final EventAggregator agg = new EventAggregator();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegisterGUI2(db, agg);
               // new Register();
            }
        });
    }
    
}
