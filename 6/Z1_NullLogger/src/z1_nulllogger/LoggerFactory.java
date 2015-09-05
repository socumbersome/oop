/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z1_nulllogger;

import java.io.IOException;

/**
 *
 * @author ja
 */
public class LoggerFactory {
    
    private static LoggerFactory _Instance = null;
    
    public static ILogger GetLogger(LogType logType, String... Parameters) throws IOException
    {
        switch(logType) {
            case None:
                return new NoneLogger();
            case Console:
                return new ConsoleLogger();
            case File:
                return new FileLogger(Parameters[0]);
            default:
                return new NoneLogger();
        }
    }
    
    public static LoggerFactory Instance()
    {
        if(_Instance == null ) {
            _Instance = new LoggerFactory();
        }
        return _Instance;
    };
    
    private LoggerFactory() {
        
    };
}
