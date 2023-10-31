package Lab3;

import java.util.Random;

public class GoalKeeper extends Player {
    private int noSaves;
    private int goalsLet;

    public GoalKeeper(Gender g, String n, int a, Country nat){
        super(g,n,a,nat);
    }

    public void updateStats(Match m){
        Random random = new Random();
        Player p = (Player) this;

        if (m.homeTeam.getPlayers().contains(p)) {
            noSaves = 
        } else if (m.awayTeam.getPlayers().contains(p)) {
            System.out.println(p.getName() + " is on the away team.");
        }
        
        this.noSaves = random.nextInt(6);   
        this.goalsLet = random.nextInt(6);
    }
}
