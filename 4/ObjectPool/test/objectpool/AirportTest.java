/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectpool;

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
public class AirportTest {
    
    @Rule public ExpectedException exception = ExpectedException.none();
    
    public AirportTest() {
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
    public void get10Planes() {
        Airport airport = new Airport();
        for(int i = 0; i < 10; i++) {
            Plane p = airport.getPlane();
        }
    }
    
    @Test
    public void get11Planes() {
        Airport airport = new Airport();
        exception.expect(RuntimeException.class);
        for(int i = 0; i < 11; i++) {
            Plane p = airport.getPlane();
        }
    }

    @Test
    public void testLand() {
        Airport airport = new Airport();
        Plane[] planes = new Plane[10];
        for(int i = 0; i < 8; i++) {
            planes[i] = airport.getPlane();
        }
        for(int i = 0; i < 5; i++) {
            airport.lands(planes[i]);
        }
        for(int i = 0; i < 5; i++) {
            planes[i] = airport.getPlane();
        }
    }
    
    @Test
    public void foreignPlane() {
        Airport airport = new Airport();
        Airport airport2 = new Airport();
        Plane p = airport.getPlane();
        Plane p2 = airport2.getPlane();
        
        exception.expect(IllegalArgumentException.class);
        airport.lands(p2);
    }
    
}
