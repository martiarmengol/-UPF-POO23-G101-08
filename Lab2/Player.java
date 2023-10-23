package Lab2;

public class Player {
    private boolean female;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int goals;
    
    public Player(boolean g, String n, int a, Country nat) {
        female = g;
        name = n;
        age = a;
        nationality = nat;
    }

    public boolean isFemale (){
        if(female==true){
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
        return goals;
    }

    public void update_goals(int newgoals){
        goals = newgoals;
    }

    public void update(Match m){

    }
}
