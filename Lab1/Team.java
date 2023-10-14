import java.util.LinkedList;

public class Team {
    private String name;
    private Country country;
    private Gender gender;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;
    
    LinkedList<Player> playerList = new LinkedList<>();

    public Team(String n, Country c, Gender g, int matches, int wins, int ties, int losses, int scored, int against) {
        name = n;
        country = c;
        gender = g;
        noMatches = matches;
        noWins = wins;
        noTies = ties;
        noLosses = losses;
        goalsScored = scored;
        goalsAgainst = against;
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
        System.out.println("Matches:"+noMatches);
        System.out.println("Wins"+noWins);
        System.out.println("Losses:"+noLosses);
        System.out.println("Tie:"+noTies);
        System.out.println("Against:"+goalsAgainst);
        System.out.println("Goals Scored"+goalsScored);
    }
}
