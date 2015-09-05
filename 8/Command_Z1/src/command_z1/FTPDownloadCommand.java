/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command_z1;

/**
 *
 * @author ja
 */
public class FTPDownloadCommand implements ICommand {
    
    protected String server, login, password;
    protected String filename;
    
    public FTPDownloadCommand(String s, String l, String p, String f) {
        server = s;
        login = l;
        password = p;
        filename = f;
    }
    
    
    @Override
    public void execute() {
        FTPDownload.action(server, login, password, filename);
    }
    
}
