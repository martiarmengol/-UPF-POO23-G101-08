//package Lab3;

import java.util.LinkedList;
import java.util.Random;

public class Match {
    protected Team homeTeam;
    protected Team awayTeam;
    protected int awayGoals;
    protected int homeGoals;
    protected LinkedList<Player> homeScorers = new LinkedList<>();
    protected LinkedList<Player> awayScorers = new LinkedList<>();
    protected Competition competition;

    public Match(Team hT, Team aT, Competition c){
        homeTeam = hT;
        awayTeam = aT;
        competition = c;
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

    public Competition getCompetition(){
        return competition;
    }

    public void simulateMatch(){
        Random random = new Random();
    
        // Simulate the match
        int homeGoals = random.nextInt(6) + 1;  // Add 1 to ensure a positive value
        int awayGoals = random.nextInt(6) + 1;  // Add 1 to ensure a positive value



        for (int i = 0; i < homeGoals; i++) {
            int indexHome = random.nextInt(homeTeam.getPlayers().size());
            if((homeTeam.getPlayers().get(indexHome) instanceof OutFielder) == true){
                homeScorers.add(homeTeam.getPlayers().get(indexHome));
            }else{
                i--;
            }
            
        }

        for (int i = 0; i < homeGoals; i++) {
            int indexAway = random.nextInt(awayTeam.getPlayers().size());
            if((awayTeam.getPlayers().get(indexAway) instanceof OutFielder) == true){
                awayScorers.add(awayTeam.getPlayers().get(indexAway));
            }else{
                i--;
            }
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

