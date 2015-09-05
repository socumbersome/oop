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
public class Square extends AbstractShape {
    public int side;
    @Override
    public int CalculateArea() {
        return side*side;
    }
    
}
