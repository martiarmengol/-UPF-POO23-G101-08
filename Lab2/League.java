package Lab2;

import java.util.LinkedList;

public class League{
    private String name;
    private Country country;
    private Gender gender;
    LinkedList<Team> teams = new LinkedList<>();
    LinkedList<Match> matches = new LinkedList<>();

    public League(String n,Country c,Gender g){
        name = n;
        country = c;
        gender = g;
    }
    
    public String getName(){
        return name;
    }

    public Country getCountry(){
        return country;
    }

    public Gender getGender(){
        return gender;
    }

    public void addTeam(Team t){
        teams.add(t);
    }

    public void generateMatches(){
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                matches.add(new Match(team1, team2));
                matches.add(new Match(team2, team1)); 
            }
        }
    }

    public void simulateMatches(){
        for (Match match : matches) {
            match.simulateMatch(); // Simulate the match
            match.getHomeTeam().updateStats(match);
            match.getAwayTeam().updateStats(match);
        }
    }

    public void printMatches(){

    }

    public void printGoalScorers(int k){

    }
}