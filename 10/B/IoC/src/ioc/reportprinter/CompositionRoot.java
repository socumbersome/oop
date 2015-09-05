/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.reportprinter;

import ioc.reportprinter.dr.IPrinterServiceFactory;
import ioc.reportprinter.dr.PrinterServiceFactoryProvider;
import ioc.reportprinter.dr.ContainerPrinterServiceFactory;
import ioc.SimpleContainer;

/**
 *
 * @author ja
 */
public class CompositionRoot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        configureContainer();
        
        // far, far away....................
        IPrinterServiceFactory factory = (IPrinterServiceFactory)PrinterServiceFactoryProvider.getFactory();
        IReportPrinter printer = factory.createPrinter();
        printer.ReceiveData(new SomeDataResource());
        printer.PrintReport();
        printer.ReceiveData(new SomeDataResource());
        printer.PrintReport();
        
        
    }
    
    private static void configureContainer() {
        SimpleContainer container = new SimpleContainer();
        
        container.RegisterType(IDataResource.class, SomeDataResource.class, true);
        container.RegisterType(IReportFormatter.class, SomeReportFormatter.class, true);
        container.RegisterType(IReportPrinter.class, ReportPrinter.class, false);
        container.RegisterInstance(System.out);
        
        PrinterServiceFactoryProvider.setupFactory(
                new ContainerPrinterServiceFactory(container)
        );
        
    }
    
}
