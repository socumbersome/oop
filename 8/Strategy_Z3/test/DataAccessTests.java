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
import strategy_z3.*;

/**
 *
 * @author ja
 */
public class DataAccessTests {
    
    public DataAccessTests() {
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
        XMLLongestNodeStrategy strg = new XMLLongestNodeStrategy(path);
        DataAccessHandlerContext ctx = new DataAccessHandlerContext(strg);
        ctx.execute();
    }
    
    @Test
    public void dbsum() {
        MyDatabase db = new MyDatabase();
        db.addEntry(2);
        db.addEntry(7);
        db.addEntry(-3);
        DatabaseColumnSumStrategy strg = new DatabaseColumnSumStrategy(db);
        DataAccessHandlerContext ctx = new DataAccessHandlerContext(strg);
        ctx.execute();
    }
}
