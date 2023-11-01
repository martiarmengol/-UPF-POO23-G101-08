package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Cup extends Competition {
    Random random = new Random();
    private ArrayList<Team>[] tr;
    private ArrayList<Match>[] mr;

    public Cup(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);

        tr = new ArrayList[1];
        mr = new ArrayList[1];
    }

    public void generateMatches() {
        ArrayList<Team> initialTeams = new ArrayList<>(teams);
        Collections.shuffle(initialTeams); // Randomize the teams

        tr[0] = new ArrayList<>(initialTeams);
        mr[0] = new ArrayList<>();

        int round = 0;

        while (tr[round].size() > 1) {
            int numMatches = tr[round].size() / 2;
            tr[round + 1] = new ArrayList<>();
            mr[round + 1] = new ArrayList<>();

            for (int i = 0; i < numMatches; i++) {
                Team homeTeam = tr[round].get(i);
                Team awayTeam = tr[round].get(i + numMatches);
                Match match = new Match(homeTeam, awayTeam);
                mr[round + 1].add(match);

                // Simulate the match
                match.simulateMatch();

                // Determine the winner
                if (match.getHomeGoals() > match.getAwayGoals()) {
                    tr[round + 1].add(homeTeam);
                } else {
                    tr[round + 1].add(awayTeam);
                }
            }

            round++;
        }
    }

    public void simulateMatches(){
        for (ArrayList<Match> roundMatches : mr) {
            if (roundMatches != null) {
                for (Match match : roundMatches) {
                    match.simulateMatch();
                    match.getHomeTeam().updateStats(match);
                    match.getAwayTeam().updateStats(match);
                }
            }
        }
    }

    public void printBraket(){
        for (int round = 0; round < tr.length; round++) {
            System.out.println("Round " + (round + 1) + " Matches:");
            ArrayList<Match> roundMatches = mr[round];
            if (roundMatches != null) {
                for (Match match : roundMatches) {
                    System.out.println(match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
                }
            }
            System.out.println();
        }

        System.out.println("Cup Winner: " + tr[tr.length - 1].get(0).getName());
    }
    
}
