/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.servicelocator;

import ioc.SimpleContainer;
import javax.naming.ConfigurationException;

/**
 *
 * @author ja
 * Beware - it's an anti-pattern, really!
 */
public class ServiceLocator {
    
    protected static IContainerProvider containerProvider;
    protected static ServiceLocator _serviceLocator;
    
    protected ServiceLocator() {
        
    }
    
    public static void setContainerProvider(IContainerProvider cp) {
        containerProvider = cp;
    }
    
    public synchronized static ServiceLocator getCurrent() {
        if(_serviceLocator == null)
            _serviceLocator = new ServiceLocator();
        
        return _serviceLocator;
    }
    
    public <T> T getInstance(Class<T> klass) throws Exception {
        if(containerProvider == null)
            throw new ConfigurationException("Container provider hasn't been " +
                    " set yet.");
        if(klass.equals(SimpleContainer.class))
            return (T)containerProvider.giveContainer();
        return containerProvider.giveContainer().Resolve(klass);
    }
}
