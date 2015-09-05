/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openfactory;

/**
 *
 * @author ja
 */
public class OpenFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        IShape square = factory.CreateShape("Square", 5);
        factory.RegisterWorker(new RectangleFactoryWorker());
        IShape rect = factory.CreateShape("Rectangle", 3, 5);
    }
    
}
