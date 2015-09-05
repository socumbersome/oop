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
public class And extends BinaryExpression {

    public And(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }
    
    @Override
    public boolean Interpret(ExpContext context) {
        return left.Interpret(context) && right.Interpret(context);
    }
    
}
