/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import z1_nulllogger.ILogger;
import z1_nulllogger.LogType;
import z1_nulllogger.LoggerFactory;

/**
 *
 * @author ja
 */
public class LoggersTest {
    
    public LoggersTest() {
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
    public void NoneLogger() throws IOException {
        ILogger logger = LoggerFactory.GetLogger(LogType.None);
        logger.Log("Where will I go?");
        // how to check whether nothing got logged anywhere? ; )
    }
    
    @Test
    public void FileLogger() throws FileNotFoundException, IOException {
        File f = new File("filish");
        if(f.exists())
            f.delete();
        ILogger logger = LoggerFactory.GetLogger(LogType.File, "filish");
        logger.Log("I exist");
        BufferedReader br = new BufferedReader(new FileReader(new File("filish")));
        assertEquals("I exist", br.readLine());
    }
}
