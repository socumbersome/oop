/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z3_proxy;

/**
 *
 * @author ja
 */
public interface IAirport {
    public Plane getPlane();
    public void lands(Plane p);
}
