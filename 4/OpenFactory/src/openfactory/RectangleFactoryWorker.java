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
class RectangleFactoryWorker implements IShapeFactoryWorker {

    @Override
    public IShape CreateShape(Object... parameters) {
        return new Rectangle((int)parameters[0], (int)parameters[1]);
    }

    @Override
    public String TypeOfShape() {
        return "rectangle";
    }
    
}
