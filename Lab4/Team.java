//package Lab3;

import java.util.*;

public class Team {
    protected String name;
    protected Country country;
    protected Gender gender;
    protected LinkedList<Player> playerList = new LinkedList<>();
    protected HashMap<Competition,TeamStats> stats;

    public Team(String n, Country c, Gender g) {
        name = n;
        country = c;
        gender = g;
        this.stats = new HashMap<>();
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

    public void updateStats(Match match, Competition competition) {
        TeamStats teamStats = stats.get(competition);

        if (teamStats == null) {
            teamStats = new TeamStats(this);
            stats.put(competition, teamStats);
        }

        teamStats.updateStats(match);

        // Call the update method of Player on all players in the team
        for (Player player : getPlayers()) {
            player.update(match, competition);
        }
    }


    public void printStats() {
    }

    public Object getWins() {
        return null;
    }

    public Object getLosses() {
        return null;
    }

    public Object getGoalsScored() {
        return null;
    }

    public Object getGoalsAgainst() {
        return null;
    }

    public List<OutFielder> getOutfielders() {
        List<OutFielder> outfielders = new ArrayList<>();

        for (Player player : playerList) {
            if (player instanceof OutFielder) {
                outfielders.add((OutFielder) player);
            }
        }

        return outfielders;
    }

    public void update(Match match, Competition competition) {
        TeamStats teamStats = stats.get(competition);

        if (teamStats == null) {
            teamStats = new TeamStats(this);
            stats.put(competition, teamStats);
        }

        teamStats.updateStats(match);

        // Call the update method of Player on all players in the team
        for (Player player : getPlayers()) {
            player.update(match, competition);
        }
    }
}
