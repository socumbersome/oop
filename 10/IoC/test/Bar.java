/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ja
 */
public class Bar extends AbstractBar {

    private boolean done = false;
    
    @Override
    public void doBar() {
        done = true;
    }
    
    public boolean isDone() {
        return done;
    }
    
}
