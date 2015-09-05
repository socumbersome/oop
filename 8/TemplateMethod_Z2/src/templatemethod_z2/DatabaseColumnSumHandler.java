/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templatemethod_z2;

import java.util.List;

/**
 *
 * @author ja
 */
public class DatabaseColumnSumHandler extends DataAccessHandler {
    
    protected MyDatabase db;
    
    protected class DBData implements Data {
        List<Integer> col;
        
        public DBData(List<Integer> col) {
            this.col = col;
        }
    }
    
    public DatabaseColumnSumHandler(MyDatabase db) {
        this.db = db;
    }
    
    @Override
    protected void connectToData() {
        db.connect();
    }

    @Override
    protected Data getDataViaConnection() {
        return new DBData(db.getColumn());
    }

    @Override
    protected void processData(Data d) {
        int r = 0;
        DBData dbd = (DBData)d;
        for(Integer a : dbd.col)
            r += a;
        System.out.println("Sum is " + r);
    }

    @Override
    protected void closeConnection() {
        db.disconnect();
    }
    

    
}
