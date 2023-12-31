package Lab2;

import java.util.Random;

public class Player {
    private Gender gender;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;
    
    public Player(Gender g, String n, int a, Country nat) {
        gender = g;
        name = n;
        age = a;
        nationality = nat;
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

    public int getGoals(){
        return noGoals;
    }

    public void update_goals(int g){
        noGoals = g;
    }

    public void update(Match m) {
        Random random = new Random();
    
        // Update goals:
        int homeGoals = m.getHomeGoals();
        int awayGoals = m.getAwayGoals();
        this.noGoals += m.getHomeScorers().contains(this) ? homeGoals : awayGoals;
    
        // Set random values for other statistics:
        this.noTackles = random.nextInt(11); 
        this.noPasses = random.nextInt(51);  
        this.noShots = random.nextInt(6);   
        this.noAssists = random.nextInt(11); 
    }
    
}
