package Lab2;

public class Player {
    private boolean gender;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;
    
    public Player(boolean g, String n, int a, Country nat) {
        gender = g;
        name = n;
        age = a;
        nationality = nat;
    }

    public boolean isFemale (){
        if(gender==true){
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
        int homeGoals = m.getHomeGoals();
        int awayGoals = m.getAwayGoals();
        
        // Update player statistics based on the match
        this.noGoals += m.getHomeScorers().contains(this) ? homeGoals : awayGoals;
        
        // You can similarly update other statistics like tackles, passes, shots, and assists here.
    }
}
