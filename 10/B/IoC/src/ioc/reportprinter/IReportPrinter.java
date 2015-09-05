/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.reportprinter;

import java.io.IOException;

/**
 *
 * @author ja
 */
public interface IReportPrinter {
    public void ReceiveData(IDataResource dataResource);
    public void PrintReport() throws IOException, ArrayIndexOutOfBoundsException;
}
