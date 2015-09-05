/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_interpreter;

/**
 *
 * @author ja
 */
public class Neg extends UnaryExpression {

    public Neg(AbstractExpression op) {
        super(op);
    }

    @Override
    public boolean Interpret(ExpContext context) {
        return !op.Interpret(context);
    }
    
}
