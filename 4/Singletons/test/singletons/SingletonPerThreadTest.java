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
public class SingletonPerThreadTest {
    
    private class SingletonGetter implements Runnable {
        
        private SingletonPerThread spt;
        
        @Override
        public void run() {
            spt = SingletonPerThread.getInstance();
        }
        
        public SingletonPerThread getSingleton() {
            return spt;
        }
        
    }
    
    public SingletonPerThreadTest() {
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
     * Test of Create method, of class SingletonPerThread.
     */
    @Test
    public void oneThread() {
        SingletonPerThread sgt = SingletonPerThread.getInstance();
        SingletonPerThread sgt2 = SingletonPerThread.getInstance();
        assertSame(sgt, sgt2);
    }
    
    @Test
    public void twoThreads() {
        SingletonGetter sg = new SingletonGetter();
        SingletonGetter sg2 = new SingletonGetter();
        Thread t = new Thread(sg);
        Thread t2 = new Thread(sg2);
        t.start(); t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException ex) {
            fail("Threads couldn't join");
        }
        
        assertNotSame(sg.getSingleton(), sg2.getSingleton());
    }
    
}
