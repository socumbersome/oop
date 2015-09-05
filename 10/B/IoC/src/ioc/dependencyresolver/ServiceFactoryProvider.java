/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.dependencyresolver;

/**
 *
 * @author ja
 */
public class ServiceFactoryProvider {
    
    protected static IServiceFactory factory;
    
    public static void setupFactory(IServiceFactory f) {   
        factory = f;
    }
    
    public static IServiceFactory getFactory() {
        return factory;
    }
}
