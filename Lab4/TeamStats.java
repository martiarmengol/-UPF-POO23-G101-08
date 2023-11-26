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

    public int getWins() {
        return noWins;
    }

    public int getLosses() {
        return noLosses;
    }

    public int getPoints() {
        return (noWins * 3) + noTies;
    }    

    public int getNoTies() {
        return noTies;
    }

    public void updateStats(Match match) {
        if (match != null) {
            if (match.getHomeTeam() == t) {
                // Update stats based on the home team's performance
                goalsScored += match.getHomeGoals();
                goalsAgainst += match.getAwayGoals();
                if (match.getHomeGoals() > match.getAwayGoals()) {
                    noWins++;
                } else if (match.getHomeGoals() < match.getAwayGoals()) {
                    noLosses++;
                }else if(match.getHomeGoals() == match.getAwayGoals()) {
                    noTies++;
                }    
            } else if (match.getAwayTeam() == t) {
                // Update stats based on the away team's performance
                goalsScored += match.getAwayGoals();
                goalsAgainst += match.getHomeGoals();
                if (match.getAwayGoals() > match.getHomeGoals()) {
                    noWins++;
                } else if (match.getAwayGoals() < match.getHomeGoals()) {
                    noLosses++;
                }
            }
        }
    }

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
        int thisPoints = this.noWins * 3 + this.noTies;
        int otherPoints = other.noWins * 3 + other.noTies;

        // Compare based on points
        if (thisPoints != otherPoints) {
            return Integer.compare(otherPoints, thisPoints); // Sort by points in descending order
        }

        int goalDifferenceThis = this.goalsScored - this.goalsAgainst;
        int goalDifferenceOther = other.goalsScored - other.goalsAgainst;

        // Compare based on goal difference
        if (goalDifferenceThis != goalDifferenceOther) {
            return Integer.compare(goalDifferenceOther, goalDifferenceThis); // Sort by goal difference in descending order
        }

        // Compare based on goals scored
        return Integer.compare(other.goalsScored, this.goalsScored); // Sort by goals scored in descending order
    }
}
