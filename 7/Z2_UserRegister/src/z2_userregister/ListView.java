/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

import javax.swing.JList;

/**
 *
 * @author ja
 */
public class ListView extends JList implements ISubscriber {

    @Override
    public void handle(MyEventType notification) {
        if(notification instanceof RefreshUI) {
            this.updateUI();
        }
    }
    
}
