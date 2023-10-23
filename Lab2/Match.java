package Lab2;

import java.util.LinkedList;
import java.util.Random;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int awayGoals;
    private int homeGoals;
    
    LinkedList<Player> homeScorers = new LinkedList<>();
    LinkedList<Player> awayScorers = new LinkedList<>();

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

    public void simulateMatch(){
        int n = 6;
        Random random = new Random();
        int homeGoals = random.nextInt(n);
        int awayGoals = random.nextInt(n);

        for(int i=0;i<homeGoals;i++){
            int indexHome = random.nextInt(homeTeam.playerList.size());
            homeScorers.add(homeTeam.playerList.get(indexHome));
            int g = homeTeam.playerList.get(indexHome).getGoals();
            homeTeam.playerList.get(indexHome).update_goals(g+1);
        }
        
        for(int i=0;i<awayGoals;i++){
            int indexAway = random.nextInt(awayTeam.playerList.size());
            awayScorers.add(awayTeam.playerList.get(indexAway));
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
