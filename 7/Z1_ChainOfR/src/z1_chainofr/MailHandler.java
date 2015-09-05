/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z1_chainofr;

/**
 *
 * @author ja
 */
public abstract class MailHandler {
    
    protected MailHandler next = null;
    
    public void setNext(MailHandler mh) {
        if(next == null)
            next = mh;
        else
            next.setNext(mh);
    }
    
    public void receive(String s) {
        if(myResponsibility(s))
            process(s);
        else if(next != null)
            next.receive(s);
    }
    
    protected abstract void process(String s);
    
    protected abstract boolean myResponsibility(String s);
}
