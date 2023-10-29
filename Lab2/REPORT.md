# LAB 2 REPORT
## INTRODUCTION
The primary goal of the second lab is to add to the project the match and league classes. The first one is going to be used  primarily to simulate matches and the second one to create a league with different teams that play two times against every single team. Also is important to consider the relation between the classes ("composition", "aggregation"...)
### Match Class:_ 
This class represents a soccer match between two teams. The atributtes of this classe are home team, away team, home goals, away goals, and two linked lists of the home team and away team goalscorers. Methods implemented:
+ **Match(Team hT, Team aT)():** Constructor.
+ **getAwayGoals():** Goals scored by away team.
+ **getHomeGoals():** Goals scored by home team.
+ **getHomeTeam():** Team that plays at its own stadium.
+ **getAwayTeam():** Team that plays at other team's stadium.
+ **getHomeScorers():** Get linked list of goalscorers of home team.
+ **getAwayScorers():** Get linked list of goalscorers of away team.
+ **simulateMatch():** Simulates a match between two teams with a random number of goals and goalscorers.
+ **printMatch():** Prints the result of the match and the names of the goalscorers.
  
### League Class:_ 
This class represents a soccer league with diverse atributtes: league name, country, gender and two lists, one of the teams and another of the matches.
Methods implemented:

+ **League(String n,Country c,Gender g):** Constructor.
+ **getName():** Get name of the league.
+ **getCountry():** Get country of the league.
+ **getGender():** Get gender of the players of the league.
+ **getTeams():** Return linked list of the teams of the league.
+ **addTeam(Team t):** Add team to the league.
+ **generateMatches():** Create random match beween two different teams of the league.
+ **simulateMatches():** Simulates a match and updates the stats.
+ **printMatches():** Prints the result of the matches that have been simulated.

### Main Method:_ 
Use of the FootballApplication class to test all the classes and ensure that they work correctly and compiles. For example we can define some countries, teams and players and simulate matches to see if the classes methods correctly work.


## DESCRIPTION OF ALTERNATIVE
In the designign of the second lab we had diverse ideas on how to approach the code, concretely in the desing of the match class. We were not sure on how to develop the method simulateMatch, and therefore our first idea consisted in giving a list of the possible goalcorers and posssible mach results and then randomizing what happened choosing between the given outcomes. Instead of having everythin in one method, it is divided in 2. This is how it would look like:

```
public void simulateMatch() {
    
    int[] possibleScores = {0, 1, 2, 3, 4, 5};

    
    int homeGoals = possibleScores[new Random().nextInt(possibleScores.length)];

    
    int awayGoals = possibleScores[new Random().nextInt(possibleScores.length)];

    simulateScorers(homeGoals, homeTeam, homeScorers);
    simulateScorers(awayGoals, awayTeam, awayScorers);

    this.homeGoals = homeGoals;
    this.awayGoals = awayGoals;
}


private void simulateScorers(int goals, Team team, LinkedList<Player> scorers) {
    Random random = new Random();
    for (int i = 0; i < goals; i++) {
        int index = random.nextInt(team.getPlayers().size());
        scorers.add(team.getPlayers().get(index));
    }
}

```



## CONCLUSION
The current program is more extended and now we are able to simulate an entire league with different teams from the same country and players that share gender. Notice that now there are a infinite details that we can add to expand and improve this project. 

We could focus on players stats and not only record the goalscorers but also the players with more assists, tackles, saves(goalkeepers) and a lot more. There is also the possibility to improve the stats leaderboards and filter the stats by position (e.g. defenders with more goals). Also we could focus more in analyzing every team result from previous games to generate a expected result of a  match before it is even played, and we could also use this system to not just randomize every result, but to simulate the matches giving more probability to win the better team. This are some examples of how this project could be expanded.

The main issue we had working on this second lab was the implemenation of the method simulateMatch from the Match class because we didn't know how to record the goalscorers of the match and add them in the general goalscorers of each team. 

Overall, the current code is more complex but there is more work to do and as said before we could focus on different details to imporve the project quality.
