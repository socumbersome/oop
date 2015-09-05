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
public class AmericanFootballGame extends AbstractFootballGame {
    
    final protected int touchdownValue = 6;
    final protected int fieldGoalValue = 3;
    final protected int twoPointConversionValue = 2;
    final protected int safetyValue = 2;
    
    public AmericanFootballGame() {
        super(11, 60);
    }
    
    @Override
    public int getValueOfGoal(String type) {
        switch(type) {
            case "touchdown": return touchdownValue;
                // blah blah....
            default: return fieldGoalValue;
        }
    }
}
