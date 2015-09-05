/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z3_proxy;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ja
 */
public class AirportSecurityProxy implements IAirport {
    
    IAirport airport;
    
    public AirportSecurityProxy(IAirport airport) {
        this.airport = airport;
    }
    
    @Override
    public Plane getPlane() {
        if(isAccessible())
            return airport.getPlane();
        else
            throw new RuntimeException("Planes are accessible from "
            + "8 a.m. till 10 p.m. only");
    }

    @Override
    public void lands(Plane p) {
        if(isAccessible())
            airport.lands(p);
        else
            throw new RuntimeException("Planes are accessible from "
            + "8 a.m. till 10 p.m. only");
    }
    
    private boolean isAccessible() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        return (8 <= h && h < 22);
    }
    
}
