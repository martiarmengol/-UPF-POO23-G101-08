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

    public void addTeam(Team t){
        if(clubs == true && (t instanceof NationalTeam) == false){
            teams.add(t);
        }else if (clubs == false && (t instanceof NationalTeam) == true){
            teams.add(t);
        }else if (clubs == true && (t instanceof NationalTeam) == false){
            System.out.println("The competiton doesn't allow National Teams, only clubs.");
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

    /*public void printGoalScorers(int numPlayers) {
        // Create a list to store all outfielders from the teams
        List<OutFielder> outfielders = new ArrayList<>();
        
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (player instanceof OutFielder) {
                    outfielders.add((OutFielder) player);
                }
            }
        }
        
        // Sort the outfielders based on the number of goals scored
        outfielders.sort(Comparator.comparing(OutFielder::getGoals).reversed());
        
        // Print the top k goal scorers
        System.out.println("Top " + k + " Goal Scorers:");
        
        for (int i = 0; i < k && i < outfielders.size(); i++) {
            OutFielder outfielder = outfielders.get(i);
            System.out.println((i + 1) + ". " + outfielder.getName() + " (" + outfielder.getGoals() + " goals)");
        }

        // Get the list of outfielder stats for all outfielder players in the competition
        List<OutfielderStats> outfielderStatsList = getOutfielderStats();

        // Sort the outfielder stats based on the number of goals scored
        Collections.sort(outfielderStatsList);

        // Print the top k goal scorers
        System.out.println("Top " + k + " Goal Scorers:");
        for (int i = 0; i < k && i < outfielderStatsList.size(); i++) {
            OutfielderStats outfielderStats = outfielderStatsList.get(i);
            System.out.println((i + 1) + ". " + outfielderStats.name + " (" + outfielderStats.getGoals() + " goals)");
        }

        List<Player> allPlayers = new ArrayList<>();

        for (Team team : teams) {
            allPlayers.addAll(team.getPlayers());
        }

        List<Player> topScorers = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            Player topScorer = findTopScorer(allPlayers);
            if (topScorer != null) {
                topScorers.add(topScorer);
                allPlayers.remove(topScorer);
            }
        }

        System.out.println("Top " + numPlayers + " Goal Scorers:");
        int rank = 1;
        for (Player player : topScorers) {
            OutfielderStats p = (OutfielderStats) player;
            System.out.println(rank + ". " + player.getName() + " (" + p.getGoals() + " goals)");
            rank++;
        }
    }*/

    /*public void printGoalScorers(List<Player> players) {
        System.out.println("Top 12 Goal Scorers:");
        List<PlayerStats> allStats = new ArrayList<>();
    
        // Collect all PlayerStats for the given players
        for (Player player : players) {
            PlayerStats playerStats = player.getStats(this);
            if (playerStats != null) {
                allStats.add(playerStats);
            }
        }
    
        // Sort PlayerStats based on goal-scoring ability
        Collections.sort(allStats, new Comparator<PlayerStats>() {
            @Override
            public int compare(PlayerStats stats1, PlayerStats stats2) {
                // Compare based on goal-scoring ability
                // Adjust this based on your actual implementation
                return Integer.compare(((OutfielderStats) stats2).getGoals(), ((OutfielderStats) stats1).getGoals());
            }
        });
    
        // Print the top 12 goal scorers
        for (int i = 0; i < Math.min(allStats.size(), 12); i++) {
            PlayerStats playerStats = allStats.get(i);
            System.out.println(playerStats.getPlayer().getName());
        }
    }*/

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
