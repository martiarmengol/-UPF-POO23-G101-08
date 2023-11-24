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
    protected List<PlayerStats> topScorers = new ArrayList<>();

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

    public List<TeamStats> calculateTeamStats() {
        List<TeamStats> teamStatsList = new ArrayList<>();

        // Iterate over teams and update their stats
        for (Team team : teams) {
            TeamStats teamStats = new TeamStats(team);
            for (Match match : matches) {
                teamStats.updateStats(match);
            }
            teamStatsList.add(teamStats);
        }

        return teamStatsList;
    }

    public void printTopScorers(int numTopScorers) {
        System.out.println(">>>>>>>>>>TEAM STATS<<<<<<<<<<");
        System.out.println("League Table for " + getName());
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s%n", "Team", "Wins", "Losses", "Goals For", "Goals Against");
        System.out.println("---------------------------------------------------------");
    
        List<TeamStats> teamStatsList = calculateTeamStats();
        Collections.sort(teamStatsList);
    
        for (int i = 0; i < Math.min(numTopScorers, teamStatsList.size()); i++) {
            TeamStats teamStats = teamStatsList.get(i);
            Team team = teamStats.getTeam();
            
            System.out.printf("%-20s %-10d %-10d %-10d %-10d%n",
                    team.getName(),
                    teamStats.getWins(),
                    teamStats.getLosses(),
                    teamStats.getNoGoalsScored(),
                    teamStats.getNoGoalsAgainst());
        }
    
        System.out.println("---------------------------------------------------------");
        System.out.println("Top Goal Scorers:");
        System.out.println("----------------------------------------");
    
        for (PlayerStats playerStats : topScorers) {
            if (playerStats != null && playerStats.getPlayer() != null) {
                System.out.println(playerStats.getPlayer().getName());
            }
        }
    }
    
    public void updateTopScorers(List<TeamStats> teamStatsList) {
        // Clear existing top scorers
        topScorers.clear();
    
        // Collect all player stats
        List<PlayerStats> allPlayerStats = new ArrayList<>();
        for (TeamStats teamStats : teamStatsList) {
            allPlayerStats.addAll(teamStats.getPlayerStats());
        }
    
        // Sort player stats by goals scored in descending order
        allPlayerStats.sort(Comparator.comparingInt(PlayerStats::getGoalsScored).reversed());
    
        // Add the top scorers to the topScorers list
        int count = 0;
        for (PlayerStats playerStats : allPlayerStats) {
            topScorers.add(playerStats);
            count++;
            if (count == 5) { // Adjust the number (5) based on the desired top scorers count
                break;
            }
        }
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
