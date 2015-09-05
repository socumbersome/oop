/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad2_printer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ja
 */
public class ReportPrinter implements IReportPrinter {

    protected Queue<String> toPrint;
    protected IReportFormatter formatter;
    
    public ReportPrinter() {
        toPrint = new LinkedList<>();
        formatter = new ReportFormatter();
    }
    
    public ReportPrinter(IReportFormatter form) {
        toPrint = new LinkedList<>();
        formatter = form;
    }
    
    @Override
    public void ReceiveData(String data) {
        toPrint.add(formatter.FormatDocument(data));
    }

    @Override
    public void PrintReport() {
        String s = toPrint.remove();
        System.out.println(s);
    }
    
}
