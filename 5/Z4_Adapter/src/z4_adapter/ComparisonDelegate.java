/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z4_adapter;

/**
 *
 * @author ja
 */
public interface ComparisonDelegate<T> {
    int fancyCompare(T l, T r);
}
