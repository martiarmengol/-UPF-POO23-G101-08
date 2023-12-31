import java.util.*;

public class GoalKeeperStats extends PlayerStats {
    private int noSaves;
    private int goalsLet;

    public GoalKeeperStats(Player p){
        super(p);
    }

    public void updateStats(Match m){
        Random random = new Random();
        Player p = (Player) this;

        if (m.homeTeam.getPlayers().contains(p)) {
            this.noSaves += random.nextInt(10)-m.awayGoals;
            this.goalsLet += m.awayGoals;
        } else if (m.awayTeam.getPlayers().contains(p)) {
            this.noSaves += random.nextInt(10)-m.homeGoals;
            this.goalsLet += m.homeGoals;
        }
    }

    public void printStats(){
        System.out.println("Statistics for Goalkeeper " + getName() + ":");
        System.out.println("Saves: " + noSaves);
        System.out.println("Goals Let In: " + goalsLet);
        System.out.println();
    }

    public int compareTo(Object o){
        return 0;
    }

}
