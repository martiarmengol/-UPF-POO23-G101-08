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

## CONCLUSION
