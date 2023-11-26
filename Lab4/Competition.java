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

    public void printTopGoalScorers(int numPlayers) {
        List<OutfielderStats> goalScorers = getOutfielderStats();

        goalScorers.sort(OutfielderStats::compareTo);

        System.out.println("Top Goal Scorers for " + getName());
        System.out.println("----------------------------------------");
        for (int i = 0; i < Math.min(numPlayers, goalScorers.size()); i++) {
            OutfielderStats scorer = goalScorers.get(i);
            System.out.println(scorer.getName() + ": " + scorer.getGoals() + " goals");
        }
        System.out.println("----------------------------------------");
    }

    private List<OutfielderStats> getOutfielderStats() {
        List<OutfielderStats> statsList = new ArrayList<>();

        for (Team team : teams) {
            for (Player player : team.getOutfielders()) {
                OutfielderStats outfielderStats = (OutfielderStats) player.getStats(this);
                if (outfielderStats != null) {
                    statsList.add(outfielderStats);
                }
            }
        }

        return statsList;
    }

}
