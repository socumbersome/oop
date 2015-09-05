/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strategy_z3;

import java.util.List;

/**
 *
 * @author ja
 */
public class DatabaseColumnSumStrategy implements DataAccessHandlerStrategy {

    protected MyDatabase db;
    
    protected class DBData implements Data {
        List<Integer> col;
        
        public DBData(List<Integer> col) {
            this.col = col;
        }
    }
    
    public DatabaseColumnSumStrategy(MyDatabase db) {
        this.db = db;
    }
    
    @Override
    public void connectToData() {
        db.connect();
    }

    @Override
    public Data getDataViaConnection() {
        return new DBData(db.getColumn());
    }

    @Override
    public void processData(Data d) {
        int r = 0;
        DBData dbd = (DBData)d;
        for(Integer a : dbd.col)
            r += a;
        System.out.println("Sum is " + r);
    }

    @Override
    public void closeConnection() {
        db.disconnect();
    }
    
}
