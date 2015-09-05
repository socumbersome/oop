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
import z3_visitor.*;

/**
 *
 * @author ja
 */
public class TreeVisitorsTests {
    
    public TreeVisitorsTests() {
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
    public void leavesSumNILTest() {
        AbstractTree tree = NILTree.getInstance();
        LeavesSumVisitor vis = new LeavesSumVisitor();
        tree.Accept(vis);
        assertEquals(vis.sum, 0);
    }
    
    @Test
    public void leavesSumTest() {
        AbstractTree tree = 
                new BinaryTree(
                        new BinaryTree(
                            new BinaryTree(1),
                            3,
                            new BinaryTree(2)
                        ),
                        5,
                        new BinaryTree(4)
                );
        LeavesSumVisitor vis = new LeavesSumVisitor();
        tree.Accept(vis);
        assertEquals(vis.sum, 1+2+4);
    }
    
    @Test
    public void heightTest() {
        AbstractTree tree = 
                new BinaryTree(
                        new BinaryTree(
                            new BinaryTree(1),
                            3,
                            new BinaryTree(2)
                        ),
                        5,
                        new BinaryTree(4)
                );
        HeightVisitor vis = new HeightVisitor();
        tree.Accept(vis);
        assertEquals(vis.getHeight(), 3);
    }
}
