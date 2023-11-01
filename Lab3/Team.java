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
            
            if(player instanceof OutFielder){
                ((OutFielder) player).updateStats(match);
            }else if(player instanceof GoalKeeper){
                ((GoalKeeper) player).updateStats(match);
            }
            OutFielder op = (OutFielder) player;
            op.updateGoals(op.getGoals() + goalsScoredByPlayer);
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
