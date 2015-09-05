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
public interface IShapeFactoryWorker {
    public IShape CreateShape(Object... parameters);
    
    public String TypeOfShape();
}
