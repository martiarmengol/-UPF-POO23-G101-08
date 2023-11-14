//package Lab3;

import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Random;
import java.util.*;

public class Team {
    protected String name;
    protected Country country;
    protected Gender gender;
    protected LinkedList<Player> playerList = new LinkedList<>();
    HashMap<Competition,TeamStats> stats;

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

    /*public void playMatch (int pro, int against){
        if(pro>against) noWins++;
        if(pro<against) noLosses++;
        if(pro==against) noTies++;
        noMatches++;
        goalsScored += pro;
        goalsAgainst +=against;
    }*/
}
