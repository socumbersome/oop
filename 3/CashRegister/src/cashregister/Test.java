/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cashregister;

/**
 *
 * @author ja
 */
public class Test {
    public static void main(String[] args) {
        
        ICashRegister reg = new CashRegister();
        ICashRegister reg2 = new LexCashRegister();
        
        Item[] items = new Item[3];
        items[0] = new Item(2, "jabłko");
        items[1] = new Item(5.55, "czekolada");
        items[2] = new Item(999999.9, "samolot");
        
        System.out.println(reg.CalculatePrice(items));
        
        reg.PrintBill(items);
        System.out.println("\n\n");
        
        reg2.PrintBill(items);
        
    }
    
}
