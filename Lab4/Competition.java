//package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class Competition {
    protected boolean clubs;
    protected String name;
    protected Country country;
    protected Gender gender;
    protected LinkedList<Team> teams = new LinkedList<>();
    protected LinkedList<Match> matches = new LinkedList<>();

    public Competition(boolean cl, String n, Country co, Gender g){
        clubs = cl;
        name = n;
        country = co;
        gender = g;
    }

    public LinkedList<Team> getTeams(){
        return teams;
    }

    public String getName(){
        return name;
    }

    public int getTotalPlayers() {
        int totalPlayers = 0;
        
        for (Team team : teams) {
            totalPlayers += team.getPlayers().size();
        }
        
        return totalPlayers;
    }

    public void addTeam(Team t) {
        if (clubs && !(t instanceof NationalTeam)) {
            teams.add(t);
        } else if (!clubs && (t instanceof NationalTeam)) {
            teams.add(t);
        } else {
            System.out.println("The competition doesn't allow National Teams, only clubs.");
        }
    }

    public abstract void generateMatches();

    public void simulateMatches(){
        for (Match match : matches) {
            match.simulateMatch();
            
            match.getHomeTeam().update(match,this); 
            match.getAwayTeam().update(match,this); 
            
        }
    }

    public void printMatches(){
        for (Match match : matches) {
            match.printMatch(); 
        }
    }

    public void printTopScorers(int totalPlayers) {
        List<OutfielderStats> allStats = new ArrayList<>();
    
        // Collect all OutFielderStats
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (player instanceof OutFielder) {
                    OutfielderStats stats = (OutfielderStats) player.getStats(this);
                    if (stats != null) {
                        allStats.add(stats);
                    }
                }
            }
        }
    
        // Sort the list of OutFielderStats using compareTo
        allStats.sort(OutfielderStats::compareTo);
    
        // Print the sorted list of top goal scorers
        System.out.println("Top Goal Scorers:");
        System.out.println("----------------------------------------");
        for (OutfielderStats stats : allStats) {
            if (stats.getGoals() > 0) {
                System.out.println("Player: " + stats.getPlayer().getName());
            }
        }
        System.out.println("----------------------------------------");
    }
    
    
    
    

    private Player findTopScorer(List<Player> players) {
        // Remove null elements from the list
        players.removeIf(Objects::isNull);
    
        // Sort the list based on goals scored in descending order
        players.sort(Comparator.comparingInt(player -> {
            if (player instanceof OutFielder) {
                PlayerStats stats = ((OutFielder) player).getStats(this); // adjust this line based on your actual structure
                if (stats instanceof OutfielderStats) {
                    return ((OutfielderStats) stats).getGoals();
                } else {
                    // Handle the case when the player is an OutFielder but doesn't have OutfielderStats
                    return 0;
                }
            }
            // If the player is not an OutFielder, return 0
            return 0;
        }).reversed());
    
        // Return the top scorer or null if the list is empty
        return players.isEmpty() ? null : players.get(0);
    }
    


    private List<OutfielderStats> getOutfielderStats() {
        List<OutfielderStats> outfielderStatsList = new ArrayList<>();

        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (player instanceof OutFielder) {
                    OutfielderStats outfielderStats = (OutfielderStats) player.getStats(this);
                    outfielderStatsList.add(outfielderStats);
                }
            }
        }

        return outfielderStatsList;
    }

}
