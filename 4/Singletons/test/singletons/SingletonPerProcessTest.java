/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singletons;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ja
 */
public class SingletonPerProcessTest {
    
    public SingletonPerProcessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class SingletonPerProcess.
     */
    @Test
    public void testGetInstance() {
        SingletonPerProcess sgp = SingletonPerProcess.getInstance();
        SingletonPerProcess sgp2 = SingletonPerProcess.getInstance();
        assertEquals(sgp, sgp2);
    }
    
}
