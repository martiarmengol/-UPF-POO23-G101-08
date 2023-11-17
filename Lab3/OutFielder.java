//package Lab3;

import java.util.Random;

public class OutFielder extends Player {
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;
    public OutFielder(Gender g, String n, int a, Country nat){
        super(g,n,a,nat);
    }
    
    public void updateGoals(int goalsScored) {
        noGoals += goalsScored;
    }

    public int getGoals(){
        return noGoals;
    }

    public void updateStats(Match m){
        Random random = new Random();
    
        // Update goals:
        int homeGoals = m.getHomeGoals();
        int awayGoals = m.getAwayGoals();
        this.noGoals += m.getHomeScorers().contains(this) ? homeGoals : awayGoals;
    
        // Set random values for other statistics:
        this.noTackles = random.nextInt(11); 
        this.noPasses = random.nextInt(51);  
        this.noShots = random.nextInt(6);   
        this.noAssists = random.nextInt(11); 
    }
}