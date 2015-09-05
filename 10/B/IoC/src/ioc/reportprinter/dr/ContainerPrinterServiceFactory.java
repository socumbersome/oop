/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.reportprinter.dr;

import ioc.SimpleContainer;
import ioc.dependencyresolver.ContainerServiceFactory;
import ioc.reportprinter.IReportFormatter;
import ioc.reportprinter.IReportPrinter;

/**
 *
 * @author ja
 */
public class ContainerPrinterServiceFactory 
    extends ContainerServiceFactory 
    implements IPrinterServiceFactory {

    public ContainerPrinterServiceFactory(SimpleContainer container) {
        super(container);
    }

    @Override
    public IReportPrinter createPrinter() throws Exception {
        return container.Resolve(IReportPrinter.class);
    }

    @Override
    public IReportFormatter createFormatter() throws Exception {
        return container.Resolve(IReportFormatter.class);
    }
    
}
