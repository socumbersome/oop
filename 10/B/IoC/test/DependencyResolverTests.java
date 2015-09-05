/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ioc.SimpleContainer;
import ioc.reportprinter.*;
import ioc.reportprinter.dr.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ja
 */
public class DependencyResolverTests {
    
    public DependencyResolverTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    private void configureContainerForPrinter() {
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        SimpleContainer container = new SimpleContainer();
        
        container.RegisterType(IDataResource.class, SomeDataResource.class, true);
        container.RegisterType(IReportFormatter.class, SomeReportFormatter.class, true);
        container.RegisterType(IReportPrinter.class, ReportPrinter.class, false);
        container.RegisterInstance(System.out);
        
        PrinterServiceFactoryProvider.setupFactory(
                new ContainerPrinterServiceFactory(container)
        );
        
    }
    
    private ByteArrayOutputStream baos;
    
    @Test
    public void print2Times() throws Exception {
        // sth like composition root
        configureContainerForPrinter();
        
        // imagine it's far, far away from the composition root
        
        IPrinterServiceFactory factory = 
                (IPrinterServiceFactory)PrinterServiceFactoryProvider.getFactory();
        IReportPrinter printer = factory.createPrinter();
        printer.ReceiveData(new SomeDataResource());
        printer.PrintReport();
        printer.ReceiveData(new SomeDataResource());
        printer.PrintReport();    
        
        assertEquals(baos.toString(), "data1@formatted\n" +
                "data2@formatted\n");
    }
}
