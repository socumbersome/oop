/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

/**
 *
 * @author ja
 */
public class HTTPDownload {
    public static void action(String surl) {
        System.out.println("Downloading via HTTP file " + surl);
        /*
        URL url = null;
        URLConnection con = null;
        int i;
        try {
            url = new URL(surl);
            con = url.openConnection();
            File file = new File(surl);
            BufferedInputStream bis = new BufferedInputStream(
                    con.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(file.getName()));
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            bos.flush();
            bis.close();
        } catch (MalformedInputException malformedInputException) {
            malformedInputException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
    }
}
