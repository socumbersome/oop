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
public class NILTree extends AbstractTree {
    
    private static NILTree NIL = null;
    
    public static NILTree getInstance() {
        if(NIL == null) {
            NIL = new NILTree();
        }
        return NIL;
    }
    
    private NILTree() {
        left = this;
        right = this;
        parent = this;
    }
    
    @Override
    public void Accept(TreeVisitor vis) {
        vis.visitNILTree(this);
    }
}
