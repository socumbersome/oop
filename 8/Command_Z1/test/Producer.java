
import command_z1.Automaton;
import command_z1.CopyFileCommand;
import command_z1.CreateRandomFileCommand;
import command_z1.FTPDownloadCommand;
import command_z1.HTTPDownloadCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ja
 */
 public class Producer implements Runnable {
        
        private Automaton aut;
        Random generator = new Random();
        int src, dest;
        String pass = "a";
        int serv, log, ftp, url, rf;
        int counter = 0;
        private static List<Class> cmdTypes;
        
        static {
            cmdTypes = new ArrayList<>();
            cmdTypes.add(CopyFileCommand.class);
            cmdTypes.add(CreateRandomFileCommand.class);
            cmdTypes.add(FTPDownloadCommand.class);
            cmdTypes.add(HTTPDownloadCommand.class);
        }
        
        public Producer(Automaton aut) {
            this.aut = aut;
            src = 0; dest = 0;
        }
        
        @Override
        public void run() {
            Class c;
            while(true) {
                counter++;
                c = cmdTypes.get(generator.nextInt(cmdTypes.size()));
                if(c.equals(CopyFileCommand.class)) {
                    try {
                        aut.addCommand(new CopyFileCommand("f" + src, "g" + dest));
                        System.out.println("Command 'CopyFile f" + src + " to g" + dest + "' put");
                        src++; dest++;
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(c.equals(CreateRandomFileCommand.class)) {
                    try {
                        aut.addCommand(new CreateRandomFileCommand("rf" + rf));
                        rf++;
                        System.out.println("Command 'CreateRandomFile' put");
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(c.equals(FTPDownloadCommand.class)) {
                    try {
                        aut.addCommand(new FTPDownloadCommand("s" + serv, "l" + log, pass, "f" + ftp));
                        System.out.println("Command 'FTPDownload f" + ftp + " from server s" + serv + ", user l" + log + "' put");
                        serv++; log++; ftp++;
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(c.equals(HTTPDownloadCommand.class)) {
                    try {
                        aut.addCommand(new HTTPDownloadCommand("u" + url));
                        System.out.println("Command 'HTTPDownload url u" + url + "' put");
                        url++;
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    System.out.println("sth wrong!!");
                }
                if(counter > 20)
                    break;
            }
        }
    
    }
