/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ioc.*;
import java.lang.reflect.InvocationTargetException;
import java.util.jar.Pack200;
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
public class IoCTests {
    
    private SimpleContainer c;
    @Rule public ExpectedException expexc = ExpectedException.none();
    
    public IoCTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c = new SimpleContainer();
       // expexc = ExpectedException.none();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void singleton() {
        try {
            c.RegisterType(Dummy.class, true);
            
            Dummy d1 = c.Resolve(Dummy.class);
            Dummy d2 = c.Resolve(Dummy.class);
            assertSame(d1, d2);
        } catch (Exception ex) {
            fail();
        }
    }
    
    @Test
    public void genericPair() {
        try {
            c.RegisterType(Pair.class, false);
            Pair<String, Integer> p1 = c.Resolve(Pair.class);
            p1.setA("asdf");
            p1.setB(5);
            assertEquals("asdf", p1.a);
            assertEquals(5, (long)p1.b);
        } catch (Exception ex) {
            fail();
        }
    }
    
    @Test
    public void fromRegisteredInterface() {
        try {
            c.RegisterType(IFoo.class, Foo.class, false);
            IFoo f = c.Resolve(IFoo.class);
            c.RegisterType(IFoo.class, Foo2.class, false);
            IFoo f2 = c.Resolve(IFoo.class);
            
            assertTrue(f instanceof Foo);
            assertTrue(f2 instanceof Foo2);
        } catch (Exception ex) {
            fail();
        }
    }
    
    @Test
    public void fromUnregisteredInterface() throws Exception {
        expexc.expect(InstantiationException.class);
        IFoo f = c.Resolve(IFoo.class);
    }
    
    @Test
    public void fromRegisteredAbstractClass() {
        try {
            c.RegisterType(AbstractBar.class, Bar.class, false);
            AbstractBar b = c.Resolve(AbstractBar.class);
            assertTrue(b instanceof Bar);
            b.doBar();
            Bar bb = (Bar)b;
            assertTrue(bb.isDone());
        } catch (Exception ex) {
            fail();
        }
    }
}
