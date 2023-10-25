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
        int n = 6;
        Random random = new Random();
        int homeGoals = random.nextInt(n);
        int awayGoals = random.nextInt(n);

        for(int i=0;i<homeGoals;i++){
            int indexHome = random.nextInt(homeTeam.getPlayers().size());
            homeScorers.add(homeTeam.getPlayers().get(indexHome));
            int g = homeTeam.getPlayers().get(indexHome).getGoals();
            homeTeam.getPlayers().get(indexHome).update_goals(g+1);
        }
        
        for(int i=0;i<awayGoals;i++){
            int indexAway = random.nextInt(awayTeam.getPlayers().size());
            awayScorers.add(awayTeam.getPlayers().get(indexAway));
            int g = awayTeam.getPlayers().get(indexAway).getGoals();
            awayTeam.getPlayers().get(indexAway).update_goals(g+1);
        }

    }

    public void printMatch(){
        System.out.println(homeTeam);
        System.out.println(awayTeam);
        System.out.println(awayGoals);
        System.out.println(homeGoals);
        System.out.println(homeScorers);
        System.out.println(awayScorers);
    }
}
