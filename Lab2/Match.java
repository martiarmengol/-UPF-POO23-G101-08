package Lab2;

import java.util.LinkedList;
import java.util.Random;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int awayGoals;
    private int homeGoals;
    private LinkedList<Player> homeScorers = new LinkedList<>();
    private LinkedList<Player> awayScorers = new LinkedList<>();

    public Match(Team hT, Team aT){
        homeTeam = hT;
        awayTeam = aT;
    }

    public int getAwayGoals(){
        return awayGoals;
    }

    public int getHomeGoals(){
        return homeGoals;
    }

    public Team getHomeTeam(){
        return homeTeam;
    }

    public Team getAwayTeam(){
        return awayTeam;
    }

    public LinkedList<Player> getHomeScorers() {
        return homeScorers;
    }

    public LinkedList<Player> getAwayScorers() {
        return awayScorers;
    }

    public void simulateMatch(){
        Random random = new Random();
    
        // Simulate the match
        int homeGoals = random.nextInt(6);  
        int awayGoals = random.nextInt(6);  

        for (int i = 0; i < homeGoals; i++) {
            int indexHome = random.nextInt(homeTeam.getPlayers().size());
            homeScorers.add(homeTeam.getPlayers().get(indexHome));
        }

        for (int i = 0; i < awayGoals; i++) {
            int indexAway = random.nextInt(awayTeam.getPlayers().size());
            awayScorers.add(awayTeam.getPlayers().get(indexAway));
        }

        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;

    }

    public void printMatch() {
        System.out.println(" ");
        System.out.println("Match between " + homeTeam.getName() + " and " + awayTeam.getName());
        System.out.println("Final Score: " + homeGoals + " - " + awayGoals);
        
        System.out.println("Home Team Scorers:");
        for (Player scorer : homeScorers) {
            System.out.println(scorer.getName());
        }
        
        System.out.println("Away Team Scorers:");
        for (Player scorer : awayScorers) {
            System.out.println(scorer.getName());
        }
        System.out.println(" ");
    }
    
}
