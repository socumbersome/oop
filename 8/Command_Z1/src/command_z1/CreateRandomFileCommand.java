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
public class CreateRandomFileCommand implements ICommand {
    
    private String f;
    
    public CreateRandomFileCommand(String f) {
        this.f = f;
    }
    
    @Override
    public void execute() {
        CreateRandomFile.action(f);
    }
    
}
