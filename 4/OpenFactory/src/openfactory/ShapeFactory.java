/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openfactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ja
 */
public class ShapeFactory {
    
    Map<String, IShapeFactoryWorker> workers = new HashMap<>();
    
    public void RegisterWorker(IShapeFactoryWorker worker) {
        workers.put(worker.TypeOfShape(), worker);
    }
    
    public IShape CreateShape(String shapeName, Object... parameters) {
        shapeName = shapeName.toLowerCase();
        if(workers.containsKey(shapeName))
            return workers.get(shapeName).CreateShape(parameters);
        
        switch(shapeName) {
            case "square": 
                return new Square((int)parameters[0]);
            default:
                throw new IllegalArgumentException();
        }
    }
}
