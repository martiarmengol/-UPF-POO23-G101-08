//package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Cup extends Competition {
    Random random = new Random();
    private ArrayList<ArrayList<Team>> tr;
    private ArrayList<ArrayList<CupMatch>> mr;

    public Cup(boolean s, String n, Country c, Gender g) {
        super(s, n, c, g);

        int numRounds = (int) Math.ceil(Math.log(teams.size()) / Math.log(2));
        tr = new ArrayList<>();
        mr = new ArrayList<>();

        for (int i = 0; i < numRounds; i++) {
            tr.add(new ArrayList<>());
            mr.add(new ArrayList<>());
        }
    }

    public void generateMatches() {
        ArrayList<Team> initialTeams = new ArrayList<>(teams);
        Collections.shuffle(initialTeams);
    
        tr.add(new ArrayList<>(initialTeams));
        mr.add(new ArrayList<>());
    
        int round = 0;
    
        while (tr.get(round).size() > 1) {
            int numMatches = tr.get(round).size() / 2;
            tr.add(new ArrayList<>());
            mr.add(new ArrayList<>());
    
            for (int i = 0; i < numMatches; i++) {
                Team homeTeam = tr.get(round).get(i);
                Team awayTeam = tr.get(round).get(i + numMatches);
    
                if (homeTeam != null && awayTeam != null) {
                    CupMatch match = new CupMatch(homeTeam, awayTeam);
                    mr.get(round + 1).add(match);
    
                    // Determine the winner and add it to the next round
                    if (match.getHomeGoals() > match.getAwayGoals()) {
                        tr.get(round + 1).add(homeTeam);
                    } else {
                        tr.get(round + 1).add(awayTeam);
                    }
                }
            }
    
            round++;
        }
    }
    
    public void simulateMatches() {
        for (ArrayList<CupMatch> roundMatches : mr) {
            for (CupMatch match : roundMatches) {
                match.simulateMatch();
                match.getHomeTeam().updateStats(match);
                match.getAwayTeam().updateStats(match);
                match.printMatch();
            }
        }
    }

    public void printBracket() {
        ArrayList<CupMatch> roundMatches = mr.get(0);
        for (int round = 1; round < tr.size(); round++) {
            System.out.println("ROUND " + (round) + " MATCHES:");
            roundMatches = mr.get(round);
            if (roundMatches != null) {
                for (CupMatch match : roundMatches) {
                    System.out.println(match.getHomeTeam().getName() + " VS " + match.getAwayTeam().getName());
                }
            }
            System.out.println();
        }
    
        System.out.println("CUP WINER: " + tr.get(tr.size() - 1).get(0).getName());
    }
    
}


