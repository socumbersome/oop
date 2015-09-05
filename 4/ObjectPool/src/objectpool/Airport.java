/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectpool;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ja
 */
public class Airport {
    private final int MAX_NB_OF_PLANES = 10;
    
    Set<Plane> RegisteredPlanes = new HashSet<>();
    Set<Plane> FreePlanes = new HashSet<>();
    
    public Plane getPlane() {
        if(!FreePlanes.isEmpty()) {
            Plane p = FreePlanes.iterator().next();
            FreePlanes.remove(p);
            return p;
        }
        else if(RegisteredPlanes.size() < MAX_NB_OF_PLANES) {
            Plane p = new Plane();
            RegisteredPlanes.add(p);
            return p;
        }
        throw new RuntimeException("Look my lad, I know when I see a full " +
                "airport and I'm already looking at one.");
    }
    
    public void lands(Plane p) {
        /* I assume one Airport forbids planes from other Airports to land
           on it. Otherwise it would probably be necessary to tinker with
           our constant MAX_NB_OF_PLANES (we wouldn't want suddenly to
           reject our own plane because some foreign one landed, would we?)
        */
        if(RegisteredPlanes.contains(p))
            if(!FreePlanes.contains(p))
                FreePlanes.add(p);
            else
                throw new RuntimeException("Plane " + p + " is on the airport");
        else
            throw new IllegalArgumentException("A flying saucer!");
    }
    
}
