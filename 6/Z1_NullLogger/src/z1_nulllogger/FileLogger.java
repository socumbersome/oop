/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z1_nulllogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author ja
 */
public class FileLogger implements ILogger {
    
    private final File file;
    private FileWriter fw;
    
    public FileLogger(String path) throws IOException {
        file = new File(path);
        if(!file.exists())
            file.createNewFile();
    }

    @Override
    public void Log(String Message) {
        if(file.canWrite()) {
            try {
                fw = new FileWriter(file, true); // append = true
                fw.write(Message + "\n");
                fw.flush();
            } catch (IOException ex) {
                System.out.println("failed to write to a file " + file.getName());
            }
            
        }
        else
            System.out.println("cannot write to a file + " + file.getName());
    }
}
