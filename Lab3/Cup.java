package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Cup extends Competition {
    Random random = new Random();
    int n = teams.size();
    int m = n/2;
    private ArrayList<Team>[] tr = new ArrayList[n];
    private ArrayList<Match>[] mr = new ArrayList[m];

    public Cup(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);
    }

    public void generateMatches() {
        int numRounds = 0;
        while (teams.size() > 1) {
            numRounds++;
            // Randomize the order of teams in the current round
            Collections.shuffle(teams);
            // Create a new list to store the teams for the next round
            ArrayList nextRoundTeams = new ArrayList<>();
            // Split the teams into two halves
            int half = teams.size() / 2;
            ArrayList firstHalf = new ArrayList<>(teams.subList(0, half));
            ArrayList secondHalf = new ArrayList<>(teams.subList(half, teams.size()));
            // Create a new list to store the matches for the current round
            ArrayList matches = new ArrayList<>();
            // Add matches between the first and second halves of teams
            for (int i = 0; i < half; i++) { 
                for (int j = 0; j < half; j++) { 
                    Match match = new Match(firstHalf.get(i), secondHalf.get(j)); matches.add(match); 
            } 
            } // Add a bye match for the remaining team 
            if (teams.size() % 2 == 1) { 
                matches.add(new Match(firstHalf.get(half), null)); 
            } // Add the matches for the current round to the list of matches for the current round 
            mr[numRounds - 1] = matches; // Add the teams that won their matches to the list of teams for the next round 
            for (Match match : matches) { 
                if (match.getWinner()!= null) { 
                    nextRoundTeams.add(match.getWinner()); 
                } 
            } // Remove the teams that won their matches from the list of teams for the current round 
            teams.removeAll(nextRoundTeams); // Set the list of teams for the next round to the list of teams for the current round 
            teams = nextRoundTeams; 
        } // The final round has only one match, so create a new list to store the matches 
        ArrayList finalRoundMatches = new ArrayList<>();
        // Add a match between the remaining team and null
        Match finalMatch = new Match(teams.get(0), null);
        finalRoundMatches.add(finalMatch);
        // Add the matches for the final round to the list of matches for the final round
        mr[numRounds] = finalRoundMatches;
        }

    public void simulateMatches(){

    }

    public void printBraket(){

    }
}
