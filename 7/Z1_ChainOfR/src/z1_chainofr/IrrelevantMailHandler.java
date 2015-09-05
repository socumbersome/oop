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
public class IrrelevantMailHandler extends MailHandler {
    
    SignalBox marketingdep;
    
    public IrrelevantMailHandler(SignalBox marketingdep) {
        this.marketingdep = marketingdep;
    }
    
    @Override
    protected void process(String s) {
        // sending to marketing department...
        System.out.println("sending to marketing department...");
        marketingdep.sendSignal();
    }

    @Override
    protected boolean myResponsibility(String s) {
        return true; // flood them!
    }
    
}
