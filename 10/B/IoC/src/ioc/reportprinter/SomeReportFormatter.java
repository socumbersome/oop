/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.reportprinter;

/**
 *
 * @author ja
 */
public class SomeReportFormatter implements IReportFormatter {
    
    public SomeReportFormatter() { }
    
    @Override
    public String FormatDocument(String doc) {
        return doc + "@formatted";
    }
    
}
