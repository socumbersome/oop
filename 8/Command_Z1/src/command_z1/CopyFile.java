/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;

/**
 *
 * @author ja
 */
public class CopyFile {
    
    static void action(String source, String destination) throws IOException {
        System.out.println("Copying " + source + " to " + destination);
        File sf, df;
        sf = new File(source);
        df = new File(destination);
        Files.copy(sf.toPath(), df.toPath(), REPLACE_EXISTING);
        
    }
    
}
