/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package footballmatchsystem;

import auxiliarytools.Pair;
import java.util.Date;

/**
 *
 * @author ja
 */
public class FootballMatch implements IFootballMatch {
    
    IFootballGame game;
    protected TeamOnField teamA, teamB;
    protected Date date;
    
    protected class TeamOnField {
        
        protected Team t;
        protected int score;
        
        public TeamOnField(Team t) {
            this.t = t;
            score = 0;
        }
        
        public int getScore() {
            return score;
        }
        
        public void increaseScore(int howMuch) {
            score += howMuch;
        }
        
        public void saveScore(Date d, TeamOnField opponent) {
            t.saveScore(d, score, opponent.t, opponent.getScore());
        }
        
    }
    
    public FootballMatch(IFootballGame game, Team tA, Team tB) {
        if(!teamsEligibleForGame(game, tA, tB))
            throw new IllegalArgumentException("Game requires more players "
                    + "from at least one of the teams");
        
        this.game = game;
        teamA = new TeamOnField(tA);
        teamB = new TeamOnField(tB);
        date = new Date();
        
    }
    
    protected boolean teamsEligibleForGame(IFootballGame game, Team tA, Team tB)
    {
        return game.getRequiredNumberOfPlayersPerTeam() <= tA.numberOfPlayers() &&
           game.getRequiredNumberOfPlayersPerTeam() <= tB.numberOfPlayers();
    }
    
    @Override
    public void teamScores(String which, String typeOfGoal) {
        switch(which) {
            case "A":
            case "a": teamA.increaseScore(game.getValueOfGoal(typeOfGoal)); break;
            case "B":
            case "b": teamB.increaseScore(game.getValueOfGoal(typeOfGoal)); break;
            default:
                throw new IllegalArgumentException("Teams ought to be referred "
                + "to as \"A/a\" and \"B/b\".");
        }
    }

    @Override
    public Pair<Integer, Integer> getScores() {
        return new Pair<> (teamA.getScore(), teamB.getScore());
        
    }
    
    @Override
    public void endMatch() {
        teamA.saveScore(date, teamA);
        teamB.saveScore(date, teamB);
    }
    
}
