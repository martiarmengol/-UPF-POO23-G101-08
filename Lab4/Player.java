//package Lab3;

import java.util.HashMap;
import java.util.Random;

public class Player {
    protected Gender gender;
    protected String name;
    protected int age;
    protected Country nationality;
    protected HashMap<Competition,PlayerStats> stats;
    
    public Player(Gender g, String n, int a, Country nat) {
        this.gender = g;
        this.name = n;
        this.age = a;
        this.nationality = nat;
        this.stats = new HashMap<>();
    }

    public boolean isFemale (){
        if(gender==Gender.FEMALE){
            return true;
        }else return false;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Country getNationality(){
        return nationality;
    }

    public PlayerStats getStats(Competition competition) {
        return stats.get(competition);
    }
    

    /*public void update(Match match, Competition competition) {
        PlayerStats playerStats = stats.get(competition);

        // Check if the player has statistics for the current competition
        if (playerStats == null) {
            // Create an instance of PlayerStats or its subclasses based on player type
            if (this instanceof GoalKeeper) {
                playerStats = new GoalKeeperStats(this);
            } else if (this instanceof OutFielder) {
                playerStats = new OutfielderStats(this);
            }

            stats.put(competition, playerStats);
        }

        // Update player statistics
        playerStats.updateStats(match);
    }

    public void update(Match match, Competition competition) {
        PlayerStats playerStats = stats.get(competition);
    
        // Check if the player has statistics for the current competition
        if (playerStats == null) {
            // Create an instance of PlayerStats or its subclasses based on player type
            if (this instanceof GoalKeeper) {
                playerStats = new GoalKeeperStats(this);
            } else if (this instanceof OutFielder) {
                playerStats = new OutfielderStats(this);
            }
    
            stats.put(competition, playerStats);
        }
    
        // Update player statistics
        playerStats.updateStats(match);
    
        // Debugging statement
        System.out.println("Updated stats for player " + name + ": " + playerStats);
    }*/
    public void update(Match match, Competition competition) {
        PlayerStats playerStats = stats.get(competition);
    
        // Check if the player has statistics for the current competition
        if (playerStats == null) {
            // Create an instance of PlayerStats or its subclasses based on player type
            if (this instanceof GoalKeeper) {
                playerStats = new GoalKeeperStats(this);
            } else if (this instanceof OutFielder) {
                playerStats = new OutfielderStats(this);
            }
    
            stats.put(competition, playerStats);
        }
    
        // Check if playerStats is not null before updating
        if (playerStats != null) {
            // Update player statistics
            playerStats.updateStats(match);
        } else {
            System.out.println("Error: PlayerStats is null for player " + name + " in competition " + competition.getName());
        }
    }
    
    
}
