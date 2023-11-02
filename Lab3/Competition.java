package Lab3;

import java.util.LinkedList;

public class Competition {
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

    public void addTeam(Team t){
        if(clubs == true && (t instanceof NationalTeam) == false){
            teams.add(t);
        }else{
            if(t instanceof NationalTeam){
                teams.add(t);
            }
        }
        
    }

    public void generateMatches(){
        
    }

    public void simulateMatches(){
        for (Match match : matches) {
            match.simulateMatch();
            
            match.getHomeTeam().updateStats(match); 
            match.getAwayTeam().updateStats(match); 
        }
    }

    public void printMatches(){
    
        for (Match match : matches) {
            match.printMatch(); 
        }
    }

    public void printGoalScorers(int k){
        
    }
}
