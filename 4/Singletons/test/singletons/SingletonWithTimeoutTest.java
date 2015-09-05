/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singletons;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author ja
 */
public class SingletonWithTimeoutTest {
    
    @Rule public ExpectedException exception = ExpectedException.none();
    
    public SingletonWithTimeoutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            Thread.sleep(1001);
        } catch (InterruptedException ex) {
            Logger.getLogger(SingletonWithTimeoutTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        exception = ExpectedException.none();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void lessThan1Sec() throws InstantiationException {
        try {
        SingletonWithTimeout swt = SingletonWithTimeout.getInstance();
        Thread.sleep(700);
        } catch (InstantiationException ex) {
            fail("Couldn't create the first instance");
        } catch(InterruptedException ex) {
            fail("Couldn't sleep for 700 milliseconds");
        }
        
        exception.expect(InstantiationException.class);
        SingletonWithTimeout swt2 = SingletonWithTimeout.getInstance();
    }
    
    @Test
    public void moreThan1Sec() throws InstantiationException {
        SingletonWithTimeout swt = null;
        try {
        swt = SingletonWithTimeout.getInstance();
        Thread.sleep(1001);
        } catch (InstantiationException ex) {
            fail("Couldn't create the first instance");
        } catch(InterruptedException ex) {
            fail("Couldn't sleep for 1001 milliseconds");
        }
        
        SingletonWithTimeout swt2 = SingletonWithTimeout.getInstance();
        assertNotSame(swt, swt2);
    }
    
}
