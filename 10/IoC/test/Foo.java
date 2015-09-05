/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ja
 */
public class Foo implements IFoo {
    
    private boolean done = false;
    
    @Override
    public void doSomething() {
        done = true;
    }
    
    public boolean isDone() {
        return done;
    }
    
}
