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
public interface IFootballGame {
    
    int getRequiredNumberOfPlayersPerTeam();
    int getMinimumDuration();
    
    int getValueOfGoal(String typeOfGoal);
}
