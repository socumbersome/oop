/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad6_dip;

/**
 *
 * @author ja
 */
public class ReportFormatter implements IReportFormatter {

    @Override
    public String FormatDocument(String doc) {
        return doc + "@formatted!";
    }
    
}
