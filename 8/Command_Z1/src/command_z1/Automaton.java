/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author ja
 */
public class Automaton {
    //ConcurrentLinkedQueue<ICommand> commandQueue;
    private LinkedBlockingQueue<ICommand> commandQueue;
    
    public Automaton() {
        commandQueue = new LinkedBlockingQueue<>();
    }
    
    public void addCommand(ICommand c) throws InterruptedException {
        commandQueue.put(c);
    }
    
    public ICommand getCommand() throws InterruptedException {
        return commandQueue.take();
    }
    
}
