/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ja
 */
public class CopyFileCommand implements ICommand {

    protected String source, destination;
    
    public CopyFileCommand(String s, String d) {
        source = s;
        destination = d;
    }
    
    @Override
    public void execute() {
        try {
            CopyFile.action(source, destination);
        } catch (IOException ex) {
           // Logger.getLogger(CopyFileCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
