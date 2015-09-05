/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import z4_printtreevisitor.ConsoleFileVisitor;

/**
 *
 * @author ja
 */
public class FileVisitorTests {
    
    public FileVisitorTests() {
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
    public void traverseTest() throws IOException {
        Path dir = Paths.get(""); // current dir
        ConsoleFileVisitor cfv = new ConsoleFileVisitor();
        Files.walkFileTree(dir, cfv);
    }
}
