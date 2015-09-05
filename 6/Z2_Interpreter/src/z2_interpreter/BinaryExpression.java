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
public abstract class BinaryExpression extends AbstractExpression {
    protected AbstractExpression left, right;
    
    public BinaryExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }
}
