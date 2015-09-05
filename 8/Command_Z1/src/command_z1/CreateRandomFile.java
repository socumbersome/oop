/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author ja
 */
public class CreateRandomFile {
    public static void action(String f) throws IOException {
        System.out.println("Creating random file " + f);
        File ff = new File(f);
        ff.createNewFile();
        FileWriter fw = new FileWriter(ff);
        Random r = new Random();
        String alphabet = "123xyzabcdefghijklmnopqrstuwv";
        for (int i = 0; i < 50; i++) {
            fw.write(alphabet.charAt(r.nextInt(alphabet.length())));
        } // prints 50 random characters from alphabet
      //  fw.write("sdgf");
        fw.flush();
        
    }
    
}
