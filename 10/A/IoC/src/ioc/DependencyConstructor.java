/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc;

import java.lang.annotation.*;

/**
 *
 * 
 */
@Target(value = ElementType.CONSTRUCTOR)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DependencyConstructor {
    
}
