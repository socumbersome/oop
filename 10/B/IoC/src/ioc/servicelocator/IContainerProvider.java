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
public interface IContainerProvider {
    
    public SimpleContainer giveContainer();
    
}
