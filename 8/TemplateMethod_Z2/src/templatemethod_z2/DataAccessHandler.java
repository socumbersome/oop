/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templatemethod_z2;

/**
 *
 * @author ja
 */
public abstract class DataAccessHandler {
    
    public void execute() {
        connectToData();
        Data d = getDataViaConnection();
        processData(d);
        closeConnection();
    }
    
    protected abstract void connectToData();
    
    protected abstract Data getDataViaConnection();
    
    protected abstract void processData(Data d);
    
    protected abstract void closeConnection();
}
