# LAB 1 REPORT
## _**1- INTRODUCTION: PROGRAM DESCRIPTION**_

The primary goal of the program is to model soccer players, soccer teams, and their associated data, such as player statistics and team statistics. The program must support the following functionalities:
### _Player Class:_ 
This class is designed to represent individual soccer players. It should store player-specific information such as gender, name, age, nationality, and various statistics related to their performance in matches (matches played, tackles, passes, shots, assists, and goals scored).
Methods to implement:
+ **isFemale():** Determine if the player is female.
+ **update(int t, int p, int s, int a, int g):** Update the player's statistics.
+ **printStats():** Print the player's statistics.
### _Team Class:_ 
This class represents soccer teams and their attributes. A team has a name, a country of origin, a gender (male, female, or mixed), and various statistics, including the number of matches played, wins, ties, losses, goals scored, and goals against. The class should also maintain a list of players that belong to the team.
Methods to implement:
+ **addPlayer(Player p):** Add a player to the team.
+ **removePlayer(Player p):** Remove a player from the team.
+ **playMatch(int pro, int against):** Record the outcome of a match and update team statistics.
+ **printStats():** Print the team's statistics.
### _Country Class:_ 
This class represents the nationality of players and teams. It contains the name of the country.





## _**2- ALTERNATIVE**_

In designing this system, we considered various alternatives, such as using arrays instead of linked lists, utilizing inheritance for player types, and employing more complex class relationships. However, the chosen solution adheres to basic object-oriented programming principles and simplicity.
The chosen solution employs a basic class structure with composition, encapsulation, and appropriate methods to manage the relationships between players, teams, and countries. The theoretical concepts applied in this solution include:  

+ **Encapsulation:** Each class encapsulates its attributes and provides methods to access and manipulate them. For example, the Player class encapsulates player data, the Team class encapsulates team data, and the     Country class encapsulates nationality.
 
+ **Composition:** The Team class is composed of a list of Player objects, which represents a "has-a" relationship between teams and players. This allows for flexibility in managing players belonging to teams.
  
+ **Enums:** The Gender enum is used to represent gender options (MALE, FEMALE, MIXED), providing a predefined set of choices for gender.
  

However, a potential improvement to the current architecture would be to add a “Stats” class specifically for managing player and team statistics. This situation improves the organization, adaptability, and maintainability of the code by incorporating a “Stats” object into the “Player” and “Team” classes. Each class retains a separate function by abiding by the single responsibility principle, with “Player” handling player information and “Team” managing team-related matters. Abstraction makes managing statistical data less complicated while encapsulation protects data integrity and provides controlled access to statistics. This method optimizes code readability and makes it easier for any future additions or revisions, giving player and team statistics management a solid base.

This “Stats” class would look something like this:

```
//Atributes
private int noMatches; 
private int noWins; 
private int noTies; 
private int noLosses; 
private int goalsScored; 
private int goalsAgainst;

//Methods (Examples)

public Stats() { 
    noMatches = 0; 
    noWins = 0; 
    noTies = 0; 
    noLosses = 0; 
    goalsScored = 0; 
    goalsAgainst = 0; 
} _//Constructor_

public void incrementMatches() {
noMatches++; 
}

public void incrementGoalsScored(int goals) { 
goalsScored += goals; 
}
```

## _**3- CONCLUSION**_

The created solution adheres to the object-oriented programming concepts and successfully simulates soccer players and teams. Testing revealed that the classes were appropriately implemented, and the fundamental features—adding players to teams, documenting game results, and displaying statistics—performed as intended.

Future iterations should take into account a few potential issues and enhancements. For example, the system might be expanded to include more complex statistics, like player ratings or other team characteristics. In the future, it might be difficult to handle complex game circumstances such as player replacements during matches.

Overall, the current solution offers a strong foundation for modeling soccer teams and players in an object-oriented way, but additional improvements and refinements can be investigated depending on particular use cases and requirements.

