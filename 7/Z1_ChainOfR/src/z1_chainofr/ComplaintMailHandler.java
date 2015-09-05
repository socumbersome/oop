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
public class ComplaintMailHandler extends MailHandler {

    SignalBox legalsection;
    
    public ComplaintMailHandler(SignalBox legalsection) {
        this.legalsection = legalsection;
    }
    
    @Override
    protected void process(String s) {
        // sending to legal section...
        System.out.println("sending to legal section...");
        legalsection.sendSignal();
    }

    @Override
    protected boolean myResponsibility(String s) {
        return s.contains("dis") || s.contains("complaint");
    }
    
}
