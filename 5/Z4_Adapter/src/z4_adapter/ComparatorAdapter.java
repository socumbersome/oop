/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z4_adapter;

import java.util.Comparator;

/**
 *
 * @author ja
 */
public class ComparatorAdapter<T> implements Comparator<T> {
    
    ComparisonDelegate<T> delegate;
    Comparator<T> comp;
    boolean hasDelegate = false;
    
    public ComparatorAdapter(ComparisonDelegate<T> delegate) {
        this.delegate = delegate;
        hasDelegate = true;
        
    }
    
    public ComparatorAdapter(Comparator<T> comp) {
        this.comp = comp;
    }
    
    @Override
    public int compare(T l, T r) {
        if(hasDelegate)
            return delegate.fancyCompare(l, r);
        else
            return comp.compare(l, r);
    }
    
}
