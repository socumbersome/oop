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
import templatemethod_z2.DataAccessHandler;
import templatemethod_z2.DatabaseColumnSumHandler;
import templatemethod_z2.MyDatabase;
import templatemethod_z2.XMLLongestNodeHandler;

/**
 *
 * @author ja
 */
public class DataAccessHandlersTest {
    
    public DataAccessHandlersTest() {
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
    public void xml() {
        String path = "example.xml";
        DataAccessHandler xmlh = new XMLLongestNodeHandler(path);
        xmlh.execute();
    }
    
    @Test
    public void dbsum() {
        MyDatabase db = new MyDatabase();
        db.addEntry(2);
        db.addEntry(7);
        db.addEntry(-3);
        DataAccessHandler dbcsh = new DatabaseColumnSumHandler(db);
        dbcsh.execute();
    }
}
