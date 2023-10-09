package Lab1redo;

import java.util.LinkedList;

public class Team {
    private String name;
    private Country country;
    private Gender gender;
    //private Player[] players;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;
    
    LinkedList<Player> playerList = new LinkedList<>();

    public void Team(String n, Country c, Gender g){
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
        if((p.isFemale()==true && (gender == Gender.FEMALE || gender == Gender.MIXED) ) || (p.isFemale()==false && (gender == Gender.MALE || gender == Gender.MIXED))){
            playerList.add(p);
        }
        System.out.println("The gender of the player and the Team do not match");
    }

    public void removePlayer(Player p){
        playerList.remove(p);
    }

    public void playMatch (int pro, int against){
        if(pro>against) noWins++;
        if(pro<against) noLosses++;
        if(pro==against) noTies++;
        noMatches++;
        goalsScored += pro;
        goalsAgainst +=against;
    }

    public void printStats(){
        System.out.println(noMatches);
        System.out.println(noWins);
        System.out.println(noLosses);
        System.out.println(noTies);
        System.out.println(goalsAgainst);
        System.out.println(goalsScored);
    }
}
