/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

/**
 *
 * @author ja
 */
public interface ISubscriber {
    void handle(MyEventType notification);
}
