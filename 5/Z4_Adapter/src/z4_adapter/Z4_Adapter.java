/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z4_adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ja
 */
public class Z4_Adapter {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{5,10,15, -3, 7}));
        ComparisonDelegate<Integer> del = new ComparisonDelegate<Integer>() {
            @Override
            public int fancyCompare(Integer l, Integer r) {
                return r - l;
            }
        };
        Collections.sort(list, new ComparatorAdapter<>(del));
        System.out.println(list);
        
    }
    
}
