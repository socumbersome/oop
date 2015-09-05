/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author ja
 */
public class FTPDownload {
    public static void action(String s, String l, String p, String f) {
        System.out.println("User " + l + " wants to download " + f + " from FTP server " + s);
        /*
        FTPClient ftpClient = new FTPClient();
        FileOutputStream fos = null;  
  
        try {  
         // pass directory path on server to connect  
         ftpClient.connect(s);  

         // pass username and password, returned true if authentication is  
         // successful  
         boolean login = ftpClient.login(l, p);  

         if (login) {  
          System.out.println("Connection established...");  

          fos = new FileOutputStream("files/" + f);  
          boolean download = ftpClient.retrieveFile(f,  
            fos);  
          if (download) {  
           System.out.println("File downloaded successfully !");  
          } else {  
           System.out.println("Error in downloading file !");  
          }  

          // logout the user, returned true if logout successfully  
          boolean logout = ftpClient.logout();  
          if (logout) {  
           System.out.println("Connection close...");  
          }  
         } else {  
          System.out.println("Connection fail...");  
         }  

        } catch (SocketException e) {  
         e.printStackTrace();  
        } catch (IOException e) {  
         e.printStackTrace();  
        } finally {  
         try {  
          ftpClient.disconnect();  
         } catch (IOException e) {  
          e.printStackTrace();  
         }  
        }  */
        System.out.println("User " + l + " downloaded file " + f + " from FTP server " + s);
       }  
}
