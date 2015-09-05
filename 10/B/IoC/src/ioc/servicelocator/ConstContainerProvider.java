/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.servicelocator;

import ioc.SimpleContainer;

/**
 *
 * @author ja
 */
public class ConstContainerProvider implements IContainerProvider {
    
    private final SimpleContainer sc;
    
    public ConstContainerProvider(SimpleContainer sc) {
        this.sc = sc;
    }
    
    @Override
    public SimpleContainer giveContainer() {
        return sc;
    }
    
}
