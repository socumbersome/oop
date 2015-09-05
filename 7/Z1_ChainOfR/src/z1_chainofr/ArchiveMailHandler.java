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
public class ArchiveMailHandler extends MailHandler {

    SignalBox archive;
    
    public ArchiveMailHandler(SignalBox archive) {
        this.archive = archive;
    }
    
    // different policy from other handlers!
    @Override
    public void receive(String s) {
        if(myResponsibility(s))
            process(s);
        if(next != null)
            next.receive(s);
    }
    
    
    @Override
    protected void process(String s) {
        System.out.println("putting to archive a message: " + s);
        archive.sendSignal();
    }

    @Override
    protected boolean myResponsibility(String s) {
        return true;
    }
    
}
