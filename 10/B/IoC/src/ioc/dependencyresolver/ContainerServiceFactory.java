/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.dependencyresolver;

import ioc.SimpleContainer;

/**
 *
 * @author ja
 */
public class ContainerServiceFactory implements IServiceFactory {
    
    protected final SimpleContainer container;
    
    public ContainerServiceFactory(SimpleContainer container) {
        this.container = container;
    }
}
