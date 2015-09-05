/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z3_visitor;

/**
 *
 * @author ja
 */
public abstract class AbstractTree {
    public AbstractTree left, right, parent;
    
    public abstract void Accept(TreeVisitor vis);
}
