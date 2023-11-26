//package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class League extends Competition {
    public League(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);
    }    

    public void setTeams(List<Team> teams) {
        this.teams = new LinkedList<>(teams);
    }

    public void generateMatches(){
        if(clubs ==true){
            for (int i = 0; i < teams.size(); i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    Team team1 = teams.get(i);
                    Team team2 = teams.get(j);
                    matches.add(new Match(team1, team2,this));
                    matches.add(new Match(team2, team1,this)); 
                }
            }
        }else{
            for (int i = 0; i < teams.size(); i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    NationalTeam team1 = (NationalTeam) teams.get(i);
                    NationalTeam team2 = (NationalTeam) teams.get(j);
                    matches.add(new Match(team1, team2,this));
                    matches.add(new Match(team2, team1,this)); 
                }
            }
        }
        
    }

    public void printTable() {
        List<TeamStats> teamStatsList = new ArrayList<>();
    
        for (Team team : teams) {
            TeamStats teamStats = team.getStats(this);
            if (teamStats != null) {
                teamStatsList.add(teamStats);
            }
        }
    
        // Use the compareTo method for sorting
        teamStatsList.sort(TeamStats::compareTo);
    
        System.out.println("League Table for " + getName());
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", "Team", "Wins", "Losses", "Ties", "G.For", "G.Against", "Points");
        System.out.println("---------------------------------------------------------");
        for (TeamStats teamStats : teamStatsList) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10d %-10d %-10d%n",
                    teamStats.getTeam().getName(), teamStats.getWins(),
                    teamStats.getLosses(), teamStats.getNoTies(),
                    teamStats.getNoGoalsScored(), teamStats.getNoGoalsAgainst(),
                    teamStats.getPoints());
        }
        System.out.println("---------------------------------------------------------");
    }
    
}
