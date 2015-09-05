/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad4_lsp;

/**
 *
 * @author ja
 */
public class Zad4_LSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int w = 4; int h = 5;
        
        IShape rect = new Rectangle();
        ((Rectangle)rect).Width = w; 
        ((Rectangle)rect).Height = h;
        
        //redundant
       // AreaCalculator calc = new AreaCalculator();
        
        System.out.println("prostokąt o wymiarach " +
                w + " na " + h + " ma pole " +
                rect.CalculateArea());
    }
    
}
