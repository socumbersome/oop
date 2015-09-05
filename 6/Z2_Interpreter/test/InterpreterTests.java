/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.management.RuntimeErrorException;
import z2_interpreter.Var;
import z2_interpreter.Literal;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import z2_interpreter.AbstractExpression;
import z2_interpreter.ConstExpression;
import z2_interpreter.ExpContext;
import z2_interpreter.*;

/**
 *
 * @author ja
 */
public class InterpreterTests {
    
    @Rule public ExpectedException exception = ExpectedException.none();
    
    public InterpreterTests() {
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
        exception = ExpectedException.none();
    }

    @Test
    public void SimpleExp() {
        ExpContext ctx = new ExpContext(); 
        ctx.SetValue("x", true);
        ctx.SetValue("y", false);
        AbstractExpression exp = new Or(
                new Var("y"),
                new And(
                    new Var("x"),
                    new Literal(true))
        );
        boolean res = exp.Interpret(ctx);
        assertEquals(res, true);
    }
    
    @Test
    public void VarBeyondContext() {
        ExpContext ctx = new ExpContext(); 
        ctx.SetValue("x", true);
        ctx.SetValue("y", false);
        
        AbstractExpression exp = new Or(
                new Var("y"),
                new And(
                    new Var("z"),
                    new Literal(true))
        );
        exception.expect(VarNotFoundException.class);
        exception.expectMessage("Variable z not found in current context.");
        exp.Interpret(ctx);
        
    }
}
