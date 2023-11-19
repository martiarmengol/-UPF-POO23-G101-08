//package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class Competition {
    protected boolean clubs;
    protected String name;
    protected Country country;
    protected Gender gender;
    protected LinkedList<Team> teams = new LinkedList<>();
    protected LinkedList<Match> matches = new LinkedList<>();

    public Competition(boolean cl, String n, Country co, Gender g){
        clubs = cl;
        name = n;
        country = co;
        gender = g;
    }

    public LinkedList<Team> getTeams(){
        return teams;
    }

    public String getName(){
        return name;
    }

    public int getTotalPlayers() {
        int totalPlayers = 0;
        
        for (Team team : teams) {
            totalPlayers += team.getPlayers().size();
        }
        
        return totalPlayers;
    }

    public void addTeam(Team t){
        if(clubs == true && (t instanceof NationalTeam) == false){
            teams.add(t);
        }else if (clubs == false && (t instanceof NationalTeam) == true){
            teams.add(t);
        }else if (clubs == true && (t instanceof NationalTeam) == false){
            System.out.println("The competiton doesn't allow National Teams, only clubs.");
        }
        
    }

    public abstract void generateMatches();

    public void simulateMatches(){
        for (Match match : matches) {
            match.simulateMatch();
            
            match.getHomeTeam().update(match,this); 
            match.getAwayTeam().update(match,this); 
        }
    }

    public void printMatches(){
        for (Match match : matches) {
            match.printMatch(); 
        }
    }

    public void printGoalScorers(int k) {
    // Create a list to store all outfielders from the teams
    List<OutFielder> outfielders = new ArrayList<>();
    
    for (Team team : teams) {
        for (Player player : team.getPlayers()) {
            if (player instanceof OutFielder) {
                outfielders.add((OutFielder) player);
            }
        }
    }
    
    // Sort the outfielders based on the number of goals scored
    outfielders.sort(Comparator.comparing(OutFielder::getGoals).reversed());
    
    // Print the top k goal scorers
    System.out.println("Top " + k + " Goal Scorers:");
    
    for (int i = 0; i < k && i < outfielders.size(); i++) {
        OutFielder outfielder = outfielders.get(i);
        System.out.println((i + 1) + ". " + outfielder.getName() + " (" + outfielder.getGoals() + " goals)");
    }
    }

}
