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
public class Var extends ConstExpression {

    String name;
    
    public Var(String name) {
        this.name = name;
    }

    @Override
    public boolean Interpret(ExpContext context) {
        return context.GetValue(name);
    }
    
}
