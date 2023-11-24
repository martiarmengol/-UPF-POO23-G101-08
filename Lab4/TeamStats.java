import java.util.List;

public class TeamStats extends Team implements Comparable<TeamStats>{
    protected Team t;
    protected int noMatches;
    protected int noWins;
    protected int noTies;
    protected int noLosses;
    protected int goalsScored;
    protected int goalsAgainst;

    public TeamStats(Team t){
        super(t.name,t.country,t.gender);
        this.t = t;
    }

    public Team getTeam() {
        return t;
    }

    public int getNoGoalsScored() {
        return goalsScored;
    }

    public int getNoGoalsAgainst() {
        return goalsAgainst;
    }


    public void updateStats(Match match) {

        for (Player player : t.getOutfielders()) {
            if (player instanceof OutFielder) {
                OutfielderStats outfielderStats = (OutfielderStats) player.getStats(match.getCompetition());

                // Check if outfielderStats is not null before updating
                if (outfielderStats != null) {
                    outfielderStats.updateStats(match);
                }
            }
        }

        int homeGoals = match.getHomeGoals();
        int awayGoals = match.getAwayGoals();

        if (homeGoals > awayGoals) {
            noWins++;
        } else if (homeGoals < awayGoals) {
            noLosses++;
        } else {
            noTies++;
        }

        goalsScored += homeGoals;
        goalsAgainst += awayGoals;

        noMatches++;
    }

    /*public void updateStats(Match match) {
        for (Player player : getPlayers()) {
            // Check if the player is an instance of OutFielder before casting
            if (player instanceof OutFielder) {
                OutFielder outFielder = (OutFielder) player;
                outFielder.updateStats(match);
            }
        }
    
        int homeGoals = match.getHomeGoals();
        int awayGoals = match.getAwayGoals();
    
        if (homeGoals > awayGoals) {
            noWins++;
        } else if (homeGoals < awayGoals) {
            noLosses++;
        } else {
            noTies++;
        }
    
        goalsScored += homeGoals;
        goalsAgainst += awayGoals;
    
        noMatches++;
    }*/

    public void printStats() {
        System.out.println(" ");
        System.out.println("Team: " + name + " stats");
        System.out.println("Matches: " + noMatches);
        System.out.println("Wins: " + noWins);
        System.out.println("Losses: " + noLosses);
        System.out.println("Ties: " + noTies);
        System.out.println("Goals Against: " + goalsAgainst);
        System.out.println("Goals Scored: " + goalsScored);
    
        System.out.println("Individual Player Stats:");
        for (Player player : getPlayers()) {
            PlayerStats playerStats = player.getStats(null);
            if (playerStats != null) {
                playerStats.printStats();
            }
        }
    
        System.out.println(" ");
    }
    

    @Override
    public int compareTo(TeamStats other) {
        // Compare based on the given criteria
        int pointsThis = 3 * noWins + noTies;
        int pointsOther = 3 * other.noWins + other.noTies;

        if (pointsThis != pointsOther) {
            return Integer.compare(pointsOther, pointsThis); // Sort by points in descending order
        }

        int goalDifferenceThis = goalsScored - goalsAgainst;
        int goalDifferenceOther = other.goalsScored - other.goalsAgainst;

        if (goalDifferenceThis != goalDifferenceOther) {
            return Integer.compare(goalDifferenceOther, goalDifferenceThis); // Sort by goal difference in descending order
        }

        // If all criteria are equal, sort arbitrarily
        return 0;
    }
}
