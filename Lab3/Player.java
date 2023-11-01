package Lab3;

import java.util.Random;

public class Player {
    protected Gender gender;
    protected String name;
    protected int age;
    protected Country nationality;
    protected int noMatches;
    
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

    public void update(Match m) {
        
        int goalsScoredByPlayer = m.getHomeScorers().contains()
                ? m.getHomeScorers().size()
                : m.getAwayScorers().size();
    }
    
}