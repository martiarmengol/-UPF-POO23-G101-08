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
    private int noGoals;
    
    public Player(boolean g, String n, int a, Country nat, int matches, int tackles, int passes, int shots, int assists, int goals) {
        female = g;
        name = n;
        age = a;
        nationality = nat;
        noMatches = matches;
        noTackles = tackles;
        noPasses = passes;
        noShots = shots;
        noAssists = assists;
        noGoals = goals;
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

    public void update(int t, int p, int s, int a, int g){
        noTackles = t;
        noPasses = p;
        noShots = s;
        noAssists = a;
        noGoals = g;
    }

    public void printStats(){
        System.out.println("Assists:"+noAssists);
        System.out.println("Passes"+noPasses);
        System.out.println("Goals:"+noGoals);
        System.out.println("Matches:"+noMatches);
        System.out.println("Shots:"+noShots);
        System.out.println("Tackles:"+noTackles);
    }
}

