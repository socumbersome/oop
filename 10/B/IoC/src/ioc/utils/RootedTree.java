/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.utils;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ja
 */
public class RootedTree<T> {
    
    public List<RootedTree<T> > children;
    public RootedTree<T> parent;
    public T data;
    
    public RootedTree(T data) {
        children = new LinkedList<>();
        parent = null;
        this.data = data;
    }
    
    public RootedTree<T> addChild(T newChild) {
        RootedTree<T> chtree = new RootedTree<>(newChild);
        children.add(chtree);
        chtree.parent = this;
        return chtree;
    }
    
    public boolean isOnPathToRootInclusive(T sought) {
        if(data.equals(sought))
            return true;
        if(parent == null)
            return false;
        return parent.isOnPathToRootInclusive(sought);
    }
    
    public boolean isOnPathToRootExclusive(T sought) {
        if(parent == null)
            return false;
        return parent.isOnPathToRootInclusive(sought);
    }
    
    
}
