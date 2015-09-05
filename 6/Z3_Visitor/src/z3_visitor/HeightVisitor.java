/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z3_visitor;

import static java.lang.Math.max;
import java.util.Stack;

/**
 *
 * @author ja
 */
public class HeightVisitor extends TreeVisitor {
    
    private Stack<Integer> subtreesHeights;
    
    public HeightVisitor() {
        subtreesHeights = new Stack<>();
    }
    
    @Override
    public void visitBinaryTree(BinaryTree bt) {
        int a, b;
        a = subtreesHeights.pop();
        b = subtreesHeights.pop();
        subtreesHeights.push(max(a, b) + 1);
    }

    @Override
    public void visitNILTree(NILTree NIL) {
        subtreesHeights.push(0);
    }
    
    public int getHeight() {
        return subtreesHeights.pop();
    }
    
}
