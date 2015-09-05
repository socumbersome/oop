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
public class LeavesSumVisitor extends TreeVisitor {

    public int sum;
    
    public LeavesSumVisitor() {
        sum = 0;
    }
    
    @Override
    public void visitBinaryTree(BinaryTree bt) {
        if(bt.isLeaf())
            sum += bt.value;
    }

    @Override
    public void visitNILTree(NILTree NIL) {
        
    }
    
}
