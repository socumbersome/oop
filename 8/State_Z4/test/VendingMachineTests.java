/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import state_z4.*;
import state_z4.IVendingMachine;
import state_z4.VMProduct;
import state_z4.VendingMachine;

/**
 *
 * @author ja
 */
public class VendingMachineTests {
    
    public VendingMachineTests() {
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
    public void simple() {
        Set<VMProduct> ps = new HashSet<>();
        ps.add(new Bar());
        ps.add(new Coffee());
        ps.add(new Villa());
        VendingMachine vm = new VendingMachine(ps);
        IVendingMachine ivm = vm;
        assertEquals(ivm.buy(), false);
        ivm.putMoney(3);
        assertEquals(ivm.buy(), false);
        ivm.pickProduct(new Coffee());
        assertEquals(ivm.buy(), false);
        ivm.pickProduct(new Bar());
        assertEquals(ivm.buy(), true);
        assertEquals(vm.state, new VMUnset());
        
    }
}
