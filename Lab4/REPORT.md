# LAB 4 REPORT
## INTRODUCTION

 The focus of this fourth lab lies on creating the Java classes outlined in Seminar 4, with particular emphasis on the execution of the Comparable interface implementation. The main objective is to devise a system 
 to sort both league tables and goal scorers. We will also implement a Dictionary to work with the stats. Finally implment printing methods for league tables and goal scorers.

 ### Sorting League Tables:
 Depending on the results of the matches, each teams is sorted with the best teams at the top. The criteria we will use is the general one in football: Win= 3 points, Tie = 1 point, Loss = 0 points.
 
 So we order the teams comparing their points were the best tems have the most. 
 In case 2 teams are tied in points we first compare the goal difference in all the games they have independetly played (goalsFor- goalsAgainst).
 If 2 teams are tied in both points and goal difference, we pritoerize the team with more goals scored.
 In TeamStats we have overrided compareTo to sort the teams. 
 
 Notice that compareTo will return -1 if the currentinstance of TeamStats should be sorted before another, 0 if they are equal, and 1 if the current instance should be sorted after another.
 
 This is the corresponding code that can be found in the class TeamStats:
 ```

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





```

 
 ### Sorting  Goal Scorers:
 In this case is more simple since we just have to sort the goal scorers according to the total goals they have scored and to do so we just have to compare noGoals in the class OutfielderStats of all the players.
 Here is the corresponding code:

 ```

    @Override
    public int compareTo(OutfielderStats other) {
        return Integer.compare(other.noGoals, this.noGoals); // Sort by goals in descending order
    }


```
As we can clearly se we have only have to override the method compareTo in OutfielderStats.


 ### Implementation Dictionary:

Now we have to use a Dictionary to implement statistics of all competitions. To do so we will use the existing class HashMap. This  has to be created in the constructor of Team and
Player. The main purpose is to be a le to modifiy the stats of a team and a player after a match of a competition is played.

For the team stats initially we have to check the dictionary to determine whether the team possesses any statistics linked to the competition. If not then we will generate a instance of TeamStats and append it to the dictionary corresponding to the ongoing competition and subsequently execute the updateStats method of TeamStats, incorporating the provided match details. 
Corresponding code:

```
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
```
For the player statistics following participation in a match within a specified competition the method initiates by inspecting the dictionary to determine whether the player possesses any statistics linked to the specified competition. If not it is necessary to create a new instance PlayerStats object and include it in the dictionary corresponding to the ongoing competition.
Corresponding code:
```
public abstract class PlayerStats extends Player{
    protected Player player;
    protected int noMatches;

    public PlayerStats(Player p){
        super(p.gender, p.name, p.age, p.nationality);
    }

    public Player getPlayer(){
        return player;
    }

    public abstract void updateStats(Match m);
    public abstract void printStats();
}


```

 ### Printing Goal Scorers & League Table:
 The concluding phase of the lab session involves the printing of league tables and goal scorers. Within the League class, we implement the printTable method. This method operates by generating a list of TeamStats and populating it with the team statistics from all participating teams in the ongoing competition, achieved through calls to the getStats method of Team. Subsequently, the list of TeamStats can be easily sorted utilizing the Collections.sort method.
 This is the method code: 
 
 ```
public void printTable() {
        List<TeamStats> teamStatsList = new ArrayList<>();
    
        for (Team team : teams) {
            TeamStats teamStats = team.getStats(this);
            if (teamStats != null) {
                teamStatsList.add(teamStats);
            }
        }
    
        // Use the compareTo method for sorting
        teamStatsList.sort(TeamStats::compareTo);
    
        System.out.println("League Table for " + getName());
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", "Team", "Wins", "Losses", "Ties", "G.For", "G.Against", "Points");
        System.out.println("---------------------------------------------------------");
        for (TeamStats teamStats : teamStatsList) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10d %-10d %-10d%n",
                    teamStats.getTeam().getName(), teamStats.getWins(),
                    teamStats.getLosses(), teamStats.getNoTies(),
                    teamStats.getNoGoalsScored(), teamStats.getNoGoalsAgainst(),
                    teamStats.getPoints());
        }
        System.out.println("---------------------------------------------------------");
    }


```

And now the last thig we have to do is implement the method printGoalScorers of the Competition class and to do so we have also implemented the method getOutfielderStats, which
returns a list of OutfielderStats for all outfielder players of the competition: 
This is the code of both methods implemented in the competition class: 


```
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


```


## DESCRIPTION OF ALTERNATIVE  

In this lab we had to work and implement new things we hadn't wroked with before, that's why before correctly developing everything we had to try different approaches. In this case a alternative approach with the implementation of the Dictionary. Our first idea was something we learned last year working with C, we thought that it could be a good idea  to insted of using HashMap, read the player and team stats from a file, and have a file for every different competition. Even though it could be a good idea we have not been thaught how to work with files in Java and that's why we prefered to follow the instruction and use HashMap to implement the Dictionary.


## CONCLUSION
