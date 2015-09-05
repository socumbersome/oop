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
public class LaudatoryMailHandler extends MailHandler {
    
    SignalBox chairmanslair;
    
    public LaudatoryMailHandler(SignalBox chairmanslair) {
        this.chairmanslair = chairmanslair;
    }
    
    @Override
    protected void process(String s) {
        // sending to chairman ...
        System.out.println("sending to chairman...");
        chairmanslair.sendSignal();
    }

    @Override
    protected boolean myResponsibility(String s) {
        return s.contains("bravo") || s.contains("congratulations");
    }
    
}
