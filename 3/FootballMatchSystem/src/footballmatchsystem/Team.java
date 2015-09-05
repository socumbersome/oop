/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package footballmatchsystem;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ja
 */
public class Team {
    protected Set<Player> players;
    
    public Team() {
        players  = new TreeSet<>();
    }
    
    public Team(Set<Player> players) {
        this.players = players;
    }
    
    public void addPlayer(Player p) {
        players.add(p);
    }
    
    public int numberOfPlayers() {
        return players.size();
    }

    void saveScore(Date date, int score, Team op, int opScore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
