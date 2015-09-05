/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import java.util.ArrayList;
import java.util.Arrays;
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
public class GenericFactoryTest {
    
    @Rule public ExpectedException exception = ExpectedException.none();
    
    public GenericFactoryTest() {
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
    
    @Test
    public void differentNotSingletons() throws Exception {
        GenericFactory factory = new GenericFactory();
        ExampleType ex1 = (ExampleType) factory.CreateObject("factory.ExampleType", false);
        ExampleType ex2 = (ExampleType) factory.CreateObject("factory.ExampleType", false);
        
        assertNotSame(ex1, ex2);
    }
    
    @Test
    public void sameSingletons() throws Exception {
        GenericFactory factory = new GenericFactory();
        ExampleType ex1 = (ExampleType) factory.CreateObject("factory.ExampleType", false);
        ExampleType ex2 = (ExampleType) factory.CreateObject("factory.ExampleType", true);
        
        assertSame(ex1, ex2);
    }
    
    @Test
    public void arrayListTest() throws Exception {
        GenericFactory factory = new GenericFactory();
        ArrayList<Integer> list = (ArrayList<Integer>) factory.CreateObject(
                "java.util.ArrayList", 
                false);
        list.add(5); list.add(10); list.add(15);
        
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{5,10,15}));
        
        assertEquals(list, list2);
    }
    
    @Test
    public void differentGenericNotSingletons() throws Exception {
        GenericFactory factory = new GenericFactory();
        ExGen<Double> ex1 = (ExGen<Double>) factory.CreateObject("factory.ExGen", 
                false,
                new Object[]{new Double(3.14), new Integer(5)});
        ExGen<Double> ex2 = (ExGen<Double>) factory.CreateObject("factory.ExGen", 
                false,
                new Object[]{new Double(3.14), new Integer(5)});
        
        assertNotSame(ex1, ex2);
    }
    
    @Test
    public void sameGenericSingletons() throws Exception {
        GenericFactory factory = new GenericFactory();
        ExGen<Double> ex1 = (ExGen<Double>) factory.CreateObject("factory.ExGen", 
                false,
                new Object[]{new Double(3.14), new Integer(5)});
        ExGen<Double> ex2 = (ExGen<Double>) factory.CreateObject("factory.ExGen", 
                true,
                new Object[]{new Double(3.14), new Integer(5)});
        
        assertSame(ex1, ex2);
    }
    
}
