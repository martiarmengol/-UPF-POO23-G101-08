package Lab2;

import java.util.LinkedList;
import java.util.Random;

public class Team {
    private String name;
    private Country country;
    private Gender gender;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;
    private LinkedList<Player> playerList = new LinkedList<>();

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

    public void addPlayer(Player p){
        playerList.add(p);
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
            int goalsScoredByPlayer = match.getHomeScorers().contains(player)
                ? match.getHomeScorers().size()
                : match.getAwayScorers().size();
    
            player.update(match); // Update player's stats based on the match
        }
    }
    


    public void printStats(){
        System.out.println("Matches:"+noMatches);
        System.out.println("Wins"+noWins);
        System.out.println("Losses:"+noLosses);
        System.out.println("Tie:"+noTies);
        System.out.println("Against:"+goalsAgainst);
        System.out.println("Goals Scored"+goalsScored);
    }
}
