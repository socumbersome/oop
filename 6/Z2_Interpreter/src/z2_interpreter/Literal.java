package z2_interpreter;


import z2_interpreter.ConstExpression;
import z2_interpreter.ExpContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ja
 */
public class Literal extends ConstExpression{
    
    boolean val;
    
    public Literal(boolean val) {
        this.val = val;
    }
    
    @Override
    public boolean Interpret(ExpContext context) {
        return val;
    }
    
}
