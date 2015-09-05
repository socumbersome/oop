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
public class BinaryTree extends AbstractTree {
    
    public int value;
    
    public BinaryTree(int v) {
        left = NILTree.getInstance();
        right = NILTree.getInstance();
        parent = NILTree.getInstance();
        value = v;
    }
    
    public BinaryTree(AbstractTree l, int v, AbstractTree r) {
        left = l;
        l.parent = this;
        right = r;
        r.parent = this;
        parent = NILTree.getInstance();
        value = v;
    }
    
    public boolean isLeaf() {
        return left == NILTree.getInstance() && right == NILTree.getInstance();
    }
    
    public boolean isRoot() {
        return parent == NILTree.getInstance();
    }
    
    @Override
    public void Accept(TreeVisitor vis) {
        left.Accept(vis);
        right.Accept(vis);
        
        vis.visitBinaryTree(this);
    }
}
