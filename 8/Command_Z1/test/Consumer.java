
import command_z1.Automaton;
import command_z1.ICommand;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ja
 */
public class Consumer implements Runnable {
    
    Automaton aut;
    
    public Consumer(Automaton aut) {
        this.aut = aut;
    }
    
    @Override
    public void run() {
        ICommand c;
        while(true) {
            try {
                c = aut.getCommand();
                c.execute();
            } catch (InterruptedException ex) {
                //Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
