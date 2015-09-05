/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ja
 */
public class Z2_Decorator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("pliczek", ".tmp");
        FileOutputStream ftw = new FileOutputStream(file);
        CaesarOutputStream caeToWrite = new CaesarOutputStream(ftw, 5);
        
        caeToWrite.write('a');
        caeToWrite.write(3);
        
        FileInputStream ftr = new FileInputStream(file);
        CaesarInputStream caeToRead = new CaesarInputStream(ftr, -5);
        
        System.out.println(caeToRead.read());
        System.out.println(caeToRead.read());
    }
    
}
