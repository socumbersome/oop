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
public class DataAccessHandlerContext {
    
    DataAccessHandlerStrategy strategy;
    
    public DataAccessHandlerContext(DataAccessHandlerStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void execute() {
        strategy.connectToData();
        Data d = strategy.getDataViaConnection();
        strategy.processData(d);
        strategy.closeConnection();
    }
}
