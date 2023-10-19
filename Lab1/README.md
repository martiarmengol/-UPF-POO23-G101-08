1- INTRODUCTION: PROGRAM DESCRIPTION

The primary goal of the program is to model soccer players, soccer teams, and their associated data, such as player statistics and team statistics. The program must support the following functionalities:
Player Class: This class is designed to represent individual soccer players. It should store player-specific information such as gender, name, age, nationality, and various statistics related to their performance in matches (matches played, tackles, passes, shots, assists, and goals scored).
Methods to implement:
isFemale(): Determine if the player is female.
update(int t, int p, int s, int a, int g): Update the player's statistics.
printStats(): Print the player's statistics.
Team Class: This class represents soccer teams and their attributes. A team has a name, a country of origin, a gender (male, female, or mixed), and various statistics, including the number of matches played, wins, ties, losses, goals scored, and goals against. The class should also maintain a list of players that belong to the team.
Methods to implement:
addPlayer(Player p): Add a player to the team.
removePlayer(Player p): Remove a player from the team.
playMatch(int pro, int against): Record the outcome of a match and update team statistics.
printStats(): Print the team's statistics.
Country Class: This class represents the nationality of players and teams. It contains the name of the country.





2- ALTERNATIVE 

In designing this system, we considered various alternatives, such as using arrays instead of linked lists, utilizing inheritance for player types, and employing more complex class relationships. However, the chosen solution adheres to basic object-oriented programming principles and simplicity.
The chosen solution employs a basic class structure with composition, encapsulation, and appropriate methods to manage the relationships between players, teams, and countries. The theoretical concepts applied in this solution include:
Encapsulation: Each class encapsulates its attributes and provides methods to access and manipulate them. For example, the Player class encapsulates player data, the Team class encapsulates team data, and the Country class encapsulates nationality.
Composition: The Team class is composed of a list of Player objects, which represents a "has-a" relationship between teams and players. This allows for flexibility in managing players belonging to teams.
Enums: The Gender enum is used to represent gender options (MALE, FEMALE, MIXED), providing a predefined set of choices for gender.

A potential improvement to the current architecture would be to add a “Stats” class specifically for managing player and team statistics, in line with fundamental concepts of object-oriented programming. This situation improves the organization, adaptability, and maintainability of the code by incorporating a “Stats” object into the “Player” and “Team” classes. Each class retains a separate function by abiding by the single responsibility principle, with “Player” handling player information and “Team” managing team-related matters. Abstraction makes managing statistical data less complicated while encapsulation protects data integrity and provides controlled access to statistics. This method optimizes code readability and makes it easier for any future additions or revisions, giving player and team statistics management a solid base.
