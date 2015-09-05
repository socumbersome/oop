/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package footballmatchsystem;

import auxiliarytools.Pair;

/**
 *
 * @author ja
 */
public interface IFootballMatch {
    
    Pair<Integer, Integer> getScores();
    
    void teamScores(String which, String typeOfGoal);
    
    void endMatch();
}
