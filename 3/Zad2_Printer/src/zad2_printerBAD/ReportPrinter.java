/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad2_printerBAD;

import java.util.Deque;

/**
 *
 * @author ja
 */
public class ReportPrinter implements IReportPrinter {
    
    protected Deque<String> toPrint;
    protected DataResource resource;
    
    @Override
    public String GetData() {
        String s = resource.GetData();
        toPrint.addLast(s);
        return s;
    }

    @Override
    public void FormatDocument() {
        // forced specification - format only the oldest(first) document
        
        // cannot use getFirst because strings are immutable, so
        // how could one modify it....?
        String s = toPrint.pollFirst();
        
        String s2 = s; // in reality: s2 = formatted s
        
        toPrint.addFirst(s2);
    }

    @Override
    public void PrintReport() {
        String s = toPrint.pollFirst();
        System.out.println(s);
    }
    
}
