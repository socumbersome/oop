/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package footballmatchsystem;

/**
 *
 * @author ja
 */
public class GaelicFootballGame extends AbstractFootballGame {
    
    final protected int overCrossbarValue = 1;
    final protected int belowCrossbarValue = 3;
    
    public GaelicFootballGame() {
        super(15, 60);
    }
    
    @Override
    public int getValueOfGoal(String type) {
        switch(type) {
            case "overcrossbar": return overCrossbarValue;
            case "belowcrossbar": return belowCrossbarValue;
            default: return overCrossbarValue;
        }
    }
}
