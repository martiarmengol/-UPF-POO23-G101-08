//package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League extends Competition {
    public League(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);
    }    

    public void generateMatches(){
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                matches.add(new Match(team1, team2,this));
                matches.add(new Match(team2, team1,this)); 
            }
        }
    }

    public void printTable() {
        // Create a list to store TeamStats for all teams
        List<TeamStats> teamStatsList = new ArrayList<>();
    
        // Update stats for each team
        for (Team team : teams) {
            TeamStats teamStats = new TeamStats(team);
            for (Match match : matches) {
                teamStats.updateStats(match);
            }
            teamStatsList.add(teamStats);
        }
    
        // Sort the list of TeamStats
        Collections.sort(teamStatsList);
    
        System.out.println("League Table for " + getName());
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s%n", "Team", "Wins", "Losses", "Goals For", "Goals Against");
        System.out.println("---------------------------------------------------------");
        for (TeamStats teamStats : teamStatsList) {
            System.out.printf("%-20s %-10d %-10d %-10d %-10d%n", teamStats.getTeam().getName(), teamStats.getWins(),
                    teamStats.getLosses(), teamStats.getNoGoalsScored(), teamStats.getNoGoalsAgainst());
        }
        System.out.println("---------------------------------------------------------");
    }
}
