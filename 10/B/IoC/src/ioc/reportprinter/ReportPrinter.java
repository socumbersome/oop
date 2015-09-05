/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.reportprinter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ja
 */
public class ReportPrinter implements IReportPrinter {
    
    protected Queue<String> toPrint;
    protected IReportFormatter formatter;
    protected PrintStream destination;
    
    public ReportPrinter(IReportFormatter formatter, PrintStream destination) {
        toPrint = new LinkedList<>();
        this.formatter = formatter;
        this.destination = destination;
    }
    
    @Override
    public void ReceiveData(IDataResource dataResource) {
        toPrint.add(formatter.FormatDocument(dataResource.GetData()));
    }

    @Override
    public void PrintReport() throws IOException {
        if(toPrint.isEmpty())
            throw new ArrayIndexOutOfBoundsException("The printer's buffor is empty.");
        
        destination.print(toPrint.remove() + "\n");
    }
    
}
