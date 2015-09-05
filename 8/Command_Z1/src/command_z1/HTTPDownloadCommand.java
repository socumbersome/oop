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
public class HTTPDownloadCommand implements ICommand {

    String url;
    
    public HTTPDownloadCommand(String url) {
        this.url = url;
    }
    
    @Override
    public void execute() {
        HTTPDownload.action(url);
    }
    
}
