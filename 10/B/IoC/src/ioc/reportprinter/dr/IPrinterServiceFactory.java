/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.reportprinter.dr;

import ioc.dependencyresolver.IServiceFactory;
import ioc.reportprinter.IReportFormatter;
import ioc.reportprinter.IReportPrinter;

/**
 *
 * @author ja
 */
public interface IPrinterServiceFactory extends IServiceFactory {
    public IReportPrinter createPrinter() throws Exception;
    public IReportFormatter createFormatter() throws Exception;
}
