/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ioc.utils.Pair;
import ioc.utils.Dummy;
import ioc.servicelocator.DynamicContainerProvider;
import ioc.servicelocator.ConstContainerProvider;
import ioc.servicelocator.ServiceLocator;
import auxiliary.*;
import ioc.*;
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
   // /*
    @Test
    public void singletonsSame() {
        try {
            c.RegisterType(Dummy.class, true);
            
            Dummy d1 = c.Resolve(Dummy.class);
            Dummy d2 = c.Resolve(Dummy.class);
            assertSame(d1, d2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
            System.out.println(ex.getMessage());
            fail();
        }
    }
    
    @Test
    public void fromUnregisteredResolvableType() throws Exception {
        Dummy d = c.Resolve(Dummy.class);
        assertNotNull(d);
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
            System.out.println(ex.getMessage());
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
            System.out.println(ex.getMessage());
            fail();
        }
    }
    
    @Test
    public void fromUnregisteredAbstractClass() throws Exception {
        expexc.expect(InstantiationException.class);
        AbstractBar b = c.Resolve(AbstractBar.class);
    }
    
    @Test
    public void supertypeSingleton() throws Exception {
        expexc.expect(RuntimeException.class);
        c.RegisterType(AbstractBar.class, Bar.class, true);
        c.RegisterType(BarChild.class, BarChild.class, false);
    }
    
    @Test
    public void siblingSingleton() throws Exception {
        c.RegisterType(BarChild.class, BarChild.class, true);
        c.RegisterType(AbstractBar.class, BarChild2.class, false);

        BarChild bc1 = c.Resolve(BarChild.class);
        BarChild bc2 = c.Resolve(BarChild.class);
        assertSame(bc1, bc2);

        AbstractBar sibling = c.Resolve(AbstractBar.class);
        AbstractBar sibling2 = c.Resolve(AbstractBar.class);
        assertNotSame(sibling, sibling2);
    }
    
    @Test
    public void registerInstance() throws Exception {
        Bar b = new Bar();
        c.RegisterInstance(b);
        Bar r1 = c.Resolve(Bar.class);
        Bar r2 = c.Resolve(Bar.class);
        assertSame(r1, r2);
        assertSame(b, r1);

        c.RegisterType(Bar.class, false);
        Bar r3 = c.Resolve(Bar.class);
        assertNotSame(r1, r3);
    }
    
    @Test
    public void simpleInjectionAB() throws Exception {
        A a = c.Resolve(A.class);
        assertNotNull(a.b);
    }
    //*/
    @Test
    public void unregisteredStringConstructor() throws Exception {
        expexc.expect(InstantiationException.class);
        X x = c.Resolve(X.class);
    }
    
    @Test
    public void registeredStringConstructor() throws Exception {
        c.RegisterInstance("ala ma kota");
        X x = c.Resolve(X.class);
        assertEquals("ala ma kota", x.s);
    }
    
    @Test
    public void TBsInTreeWithoutCycle() throws Exception {
        T t = c.Resolve(T.class);
        
        assertNotNull(t.tb);
        assertNotNull(t.tb.td);
        assertNotNull(t.ta);
        assertNotNull(t.ta.tb);
        assertNotNull(t.ta.tb.td);
        assertNotNull(t.ta.tc);
        assertNotNull(t.ta.tc.tb);
        assertNotNull(t.ta.tc.tb.td);
        
        assertNotSame(t.tb, t.ta.tb);
        assertNotSame(t.ta.tc.tb, t.ta.tb);
    }
    
    @Test
    public void UBsInTreeWithCycle() throws Exception {
        expexc.expect(InstantiationException.class);
        expexc.expectMessage("Infinite");
        U u = c.Resolve(U.class);
    }
    
    @Test
    public void TrivialCycle() throws Exception {
        expexc.expect(InstantiationException.class);
        expexc.expectMessage("Infinite");
        Cyclic cy = c.Resolve(Cyclic.class);
    }
    
    @Test
    public void TwoAnnotatedConstructors() throws Exception {
        expexc.expect(InstantiationException.class);
        expexc.expectMessage("more");
        expexc.expectMessage("DependencyConstructor");
        TwoAnnotated ta = c.Resolve(TwoAnnotated.class);
    }
    
    @Test
    public void OneAnnotatedConstructor() throws Exception {
        OneAnnotated oa = c.Resolve(OneAnnotated.class);
        assertEquals(oa.wasAnnotatedChosen(), true);
    }
    
    @Test
    public void DifferentLengthsConstructors() throws Exception {
        DLC d = c.Resolve(DLC.class);
        assertEquals(d.wasLongestChosen(), true);
    }
    
    @Test
    public void PublicPrivateDependencyField() throws Exception {
        PDP p = c.Resolve(PDP.class);
        assertNotNull(p.dpub);
        assertEquals(p.isDprivNull(), true);
        assertNull(p.pub);
    }
    
    @Test
    public void SetterInjection() throws Exception {
        SI s = c.Resolve(SI.class);
        assertNotNull(s.AGetter());
    }
    
    @Test
    public void BuildUp() throws Exception {
        SI s = new SI();
        assertNull(s.AGetter());
        c.BuildUp(s);
        assertNotNull(s.AGetter());
    }
    
    @Test
    public void ServiceLocatorSimpleResolving() throws Exception {
        c.RegisterType(A.class, false);
        ServiceLocator.setContainerProvider(new ConstContainerProvider(c));
        A a = ServiceLocator.getCurrent().getInstance(A.class);
        
        assertNotNull(a);
    }
    
    @Test
    public void ConstContainerProviderInServiceLocator() throws Exception {
        ServiceLocator.setContainerProvider(new ConstContainerProvider(c));
        SimpleContainer c1 = ServiceLocator.getCurrent().getInstance(SimpleContainer.class);
        SimpleContainer c2 = ServiceLocator.getCurrent().getInstance(SimpleContainer.class);
        
        assertSame(c, c1);
        assertSame(c1, c2);
    }
    
    @Test
    public void DynamicContainerProviderInServiceLocator() throws Exception {
        ServiceLocator.setContainerProvider(new DynamicContainerProvider());
        SimpleContainer c1 = ServiceLocator.getCurrent().getInstance(SimpleContainer.class);
        SimpleContainer c2 = ServiceLocator.getCurrent().getInstance(SimpleContainer.class);
        
        assertNotSame(c1, c2);
        assertNotSame(c, c1);
    }
}
