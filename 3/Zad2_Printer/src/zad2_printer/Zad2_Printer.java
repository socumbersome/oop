/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad2_printer;

/**
 *
 * @author ja
 */
public class Zad2_Printer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataResource res = new DataResource();
        IReportPrinter printer = new ReportPrinter();
        printer.ReceiveData(res.GetData());
        printer.PrintReport();
    }
    
}
