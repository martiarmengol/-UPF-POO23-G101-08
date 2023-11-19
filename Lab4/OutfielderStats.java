import java.util.*;

public class OutfielderStats extends PlayerStats implements Comparable<OutfielderStats>{
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public OutfielderStats(Player p){
        super(p);
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

    public void printStats(){
        
    }

    @Override
    public int compareTo(OutfielderStats other) {
        // Compare based on the number of goals
        return Integer.compare(other.noGoals, this.noGoals); // Sort by goals in descending order
    }

}
