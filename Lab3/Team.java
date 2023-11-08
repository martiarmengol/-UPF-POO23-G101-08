package Lab3;

import java.util.LinkedList;
import java.util.Random;

public class Team {
    protected String name;
    protected Country country;
    protected Gender gender;
    protected int noMatches;
    protected int noWins;
    protected int noTies;
    protected int noLosses;
    protected int goalsScored;
    protected int goalsAgainst;
    protected LinkedList<Player> playerList = new LinkedList<>();

    public Team(String n, Country c, Gender g) {
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

    public int getWins(){
        return noWins;
    }

    public int getLosses(){
        return noLosses;
    }

    public int getGoalsScored(){
        return goalsScored;
    }

    public int getGoalsAgainst(){
        return goalsAgainst;
    }

    public void addPlayer(Player p){
        if((p.isFemale() == true) && gender== Gender.FEMALE){
            playerList.add(p);
        }else if((p.isFemale() == false) && gender == Gender.MALE){
            playerList.add(p);
        }else if((p.isFemale() == false) && gender == Gender.FEMALE){
            System.out.println("The team is only for Females");
        }else if(gender == Gender.MIXED){
            playerList.add(p);
        }else if((p.isFemale() == true) && gender == Gender.MALE){
            System.out.println("The team is only for Males");
        }
        
    }

    public void removePlayer(Player p){
        playerList.remove(p);
    }

    public LinkedList<Player> getPlayers() {
        return playerList;
    }

    public void playMatch (int pro, int against){
        if(pro>against) noWins++;
        if(pro<against) noLosses++;
        if(pro==against) noTies++;
        noMatches++;
        goalsScored += pro;
        goalsAgainst +=against;
    }

    public void updateStats(Match match) {
        for (Player player : getPlayers()) {
            // Check if the player is an instance of OutFielder before casting
            if (player instanceof OutFielder) {
                OutFielder outFielder = (OutFielder) player;
                outFielder.updateStats(match);
            }
        }
    
        int homeGoals = match.getHomeGoals();
        int awayGoals = match.getAwayGoals();
    
        if (homeGoals > awayGoals) {
            noWins++;
        } else if (homeGoals < awayGoals) {
            noLosses++;
        } else {
            noTies++;
        }
    
        goalsScored += homeGoals;
        goalsAgainst += awayGoals;
    
        noMatches++;
    }
    
    


    public void printStats(){
        System.out.println(" ");
        System.out.println("Team:"+name+" stats");
        System.out.println("Matches:"+noMatches);
        System.out.println("Wins:"+noWins);
        System.out.println("Losses:"+noLosses);
        System.out.println("Tie:"+noTies);
        System.out.println("Against:"+goalsAgainst);
        System.out.println("Goals Scored:"+goalsScored);
        System.out.println(" ");
    }
}
