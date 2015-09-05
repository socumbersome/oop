/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strategy_z3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja
 */
public class MyDatabase {
    private boolean connected;
    public List<Integer> column;
    public MyDatabase() {
        connected = false;
        column = new ArrayList<>();
    }
    
    public void connect() {
        connected = true;
    }
    
    public void disconnect() {
        connected = false;
    }
    
    public boolean isConnected() {
        return connected;
    }
    
    public void addEntry(Integer i) {
        column.add(i);
    }
    
    public List<Integer> getColumn() {
        return column;
    }
}
