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
public class EuropeanFootballGame extends AbstractFootballGame {
    
    public EuropeanFootballGame() {
        super(11, 90);
    }

    @Override
    public int getValueOfGoal(String tog) {
        return 1;
    }
}
