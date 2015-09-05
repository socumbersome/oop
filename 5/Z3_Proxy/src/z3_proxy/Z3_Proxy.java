/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z3_proxy;

import java.io.PrintWriter;

/**
 *
 * @author ja
 */
public class Z3_Proxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAirport air = new Airport();
        IAirport secAir = new AirportSecurityProxy(air);
        IAirport logAir = new AirportLogProxy(air, 
                new PrintWriter(System.out), 
                new PrintWriter(System.out));
        Plane p1, p2;
        p1 = logAir.getPlane();
        p2 = secAir.getPlane();
    }
    
}
