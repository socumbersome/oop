/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strategy_z3;

/**
 *
 * @author ja
 */
public interface DataAccessHandlerStrategy {
    public void connectToData();
    public Data getDataViaConnection();
    public void processData(Data d);
    public void closeConnection();
}
