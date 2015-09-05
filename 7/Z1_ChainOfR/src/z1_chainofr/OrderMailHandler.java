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
public class OrderMailHandler extends MailHandler {

    SignalBox salesdep;
    
    public OrderMailHandler(SignalBox salesdep) {
        this.salesdep = salesdep;
    }
    
    @Override
    protected void process(String s) {
        // sending to sales department....
        System.out.println("sending to sales department...");
        salesdep.sendSignal();
    }

    @Override
    protected boolean myResponsibility(String s) {
        return s.contains("order") || s.contains("price") || s.contains("buy");
    }
    
}
