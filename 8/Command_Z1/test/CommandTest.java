/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import command_z1.Automaton;
import java.util.ArrayList;
import java.util.List;
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
public class CommandTest {
    
    public Automaton automaton;
    
    public CommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        automaton = new Automaton();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void automaton1vs2() {
        Producer pr = new Producer(automaton);
        Consumer cr1 = new Consumer(automaton);
        Consumer cr2 = new Consumer(automaton);
        Thread p, c1, c2;
        p = new Thread(pr);
        c1 = new Thread(cr1);
        c2 = new Thread(cr2);
        p.start();
        c1.start(); 
        c2.start();
    }
}
