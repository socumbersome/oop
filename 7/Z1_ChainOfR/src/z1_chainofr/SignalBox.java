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
public class SignalBox {
    
    private boolean sig = false;
    
    public void sendSignal() {
        sig = true;
    }
    
    public boolean wasSignal() {
        return sig;
    }
    
}
