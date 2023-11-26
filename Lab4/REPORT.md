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

 ### Implementation Dictionary:

 ### Printing Goal Scorers & League Table:
 

## DESCRIPTION OF ALTERNATIVE  




## CONCLUSION
