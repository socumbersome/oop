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
public class SomeDataResource implements IDataResource {
    
    public SomeDataResource() {
        s = null;
    }
    
    public SomeDataResource(String s) {
        this.s = s;
    }
    
    private static int counter = 0;
    private String s;
    
    @Override
    public String GetData() {
        counter++;
        if(s == null)
            return "data" + counter;
        return s;
    }
    
}
