/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z3_proxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ja
 */
public class AirportLogProxy implements IAirport {
    
    IAirport airport;
    PrintWriter invWriter, exitWriter;
    
    public AirportLogProxy(IAirport aip, PrintWriter invWriter, PrintWriter exitWriter) {
        airport = aip;
        this.invWriter = invWriter;
        this.exitWriter = exitWriter;
    }
    
    @Override
    public Plane getPlane() {
        invWriter.write(formatLog("getPlane (invoked)"));
        invWriter.flush();

        Plane p = airport.getPlane();

        exitWriter.write(formatLog("getPlane (returned)", p.toString()));
        exitWriter.flush();

        return p;
    }

    @Override
    public void lands(Plane p) {
        invWriter.write(formatLog("lands (invoked)", p.toString()));
        invWriter.flush();

        airport.lands(p);
        
        exitWriter.write(formatLog("lands (returned)"));
        exitWriter.flush();

    }
    
    private String formatLog(String methodName, String... params) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        for(String s : params) {
            sb.append(s + ", ");
        }
        if(sb.length() >= 2)
            sb.delete(sb.length()-2, sb.length());
        return (dateFormat.format(date) + ", " + methodName + ": " + sb.toString() + "\n");
    }
    
}
