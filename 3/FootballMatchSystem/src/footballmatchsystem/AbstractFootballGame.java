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
public abstract class AbstractFootballGame implements IFootballGame {
    final protected int playersOnFieldPerTeam;
    final protected int duration;
    
    protected AbstractFootballGame(int ppt, int d) {
        playersOnFieldPerTeam = ppt;
        duration = d;
    }
    
    @Override
    public int getRequiredNumberOfPlayersPerTeam() {
        return playersOnFieldPerTeam;
    }
    
    @Override
    public int getMinimumDuration() {
        return duration;
    }
}
