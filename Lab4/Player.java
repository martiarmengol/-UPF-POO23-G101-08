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
        gender = g;
        name = n;
        age = a;
        nationality = nat;
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
    

    public void update(Match match, Competition competition) {
        PlayerStats playerStats = getStats(competition);

        if (playerStats == null) {
            if (this instanceof GoalKeeper) {
                playerStats = new GoalKeeperStats(this);
            } else if (this instanceof OutFielder) {
                playerStats = new OutfielderStats(this);
            }

            stats.put(competition, playerStats);
        }

        if (playerStats != null) {
            playerStats.updateStats(match);
        }
    }
    
}
