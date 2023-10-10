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
    
    public void Player (boolean g, String n, int a, Country nat){
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

    public void update(int t, int p, int s, int a, int g){
        noTackles = t;
        noPasses = p;
        noShots = s;
        noAssists = a;
        noGoals = g;
    }

    public void printStats(){
        System.out.println(noAssists);
        System.out.println(noPasses);
        System.out.println(noGoals);
        System.out.println(noMatches);
        System.out.println(noShots);
    }
}

