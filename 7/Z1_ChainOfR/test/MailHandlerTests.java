/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import z1_chainofr.*;

/**
 *
 * @author ja
 */
public class MailHandlerTests {
    SignalBox archive, chairmanslair, salesdep, marketingdep, legalsection;
    
    
    public MailHandlerTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        archive = new SignalBox();
        chairmanslair = new SignalBox();
        salesdep = new SignalBox();
        marketingdep = new SignalBox();
        legalsection = new SignalBox();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hello() {
        MailHandler mh = new ArchiveMailHandler(archive);
        mh.setNext(new LaudatoryMailHandler(chairmanslair));
        mh.setNext(new ComplaintMailHandler(legalsection));
        mh.setNext(new OrderMailHandler(salesdep));
        mh.setNext(new IrrelevantMailHandler(marketingdep));
        mh.receive("great I'm so dissapointed. I only wanted to buy...");
        
        assertEquals(true, archive.wasSignal());
        assertEquals(false, chairmanslair.wasSignal());
        assertEquals(true, legalsection.wasSignal());
        assertEquals(false, salesdep.wasSignal());
        assertEquals(false, marketingdep.wasSignal());
    }
}
