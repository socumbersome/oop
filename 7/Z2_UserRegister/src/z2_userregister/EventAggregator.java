/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ja
 */
public class EventAggregator {
    
    Map<Class, List<Object> > subscribers = new HashMap<>();
    
    public void addSubscriber(ISubscriber sb, Class ev) {
        if(!subscribers.containsKey(ev))
            subscribers.put(ev, new LinkedList());
        subscribers.get(ev).add(sb);
    }
    
    public void publish(MyEventType ev) {
        if(subscribers.containsKey(ev.getClass())) {
            for(Object o : subscribers.get(ev.getClass())) {
                ISubscriber sb = (ISubscriber)o;
                sb.handle(ev);
            }
        }
    }
}
