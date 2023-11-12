# LAB 3 REPORT
## INTRODUCTION
The goal of this third lab is to add new classes that are useful to distinguish between types of matches, players, teams and competitions that were classes defined in the other labs. First, we are going to modify the players class and add goalkeeper and outfielder classes and instead of league we are going to define competition and add three types, league, cup and group play. Finally new classes national team and cup match will be also implemented. Notice that all these new classes are going to inherit attributes and methods from the already defined classes.
### Players Class:_
This class was already defined, but now since we want to distinguish goalkeepers and outfielders, we there is a modification of attributes, which now are:  gender, name, age, nationality and number of matches. Methods implemented:

+ **Player(Gender g, String n, int a, Country nat):** Constructor.
+ **isFemale():** True if player gender is female, false otherwise.
+ **getName():** Get player nationality
+ **getAge():** Get player nationality.
+ **getNationality():** Get player nationality.
+ **equals( object o):** Compare player and team gender to know eligibility.
+ **update(Match m):** Update the stats of player after a match.

### Goalkeeper Class:_
This class corresponds to the players that are goalkeepers, notice that it will inherit some attributes and methos from the player class but there are different attributes like number of saves and number of goals let. Methods implemented:

+ **Goalkeeper(Gender g, String n, int a, Country nat):** Constructor.
+ **updateStats(Match m):** Update goalkeeper stats

### Outfielder Class:_
This class corresponds to the players that are outfielders, notice that it will inherit some attributes and methos from the player class but there are different attributes like number of tackles, passes, shots assists and goals. Methods implemented:

+ **Outfielder(Gender g, String n, int a, Country nat):** Constructor.
+ **updateStats(Match m):** Update outfielder stats


### Competition Class:_
This new class can be understood as the old league class with almost the same methods and attributes. We have changed the name because now there will be 3 different types of competition: league, cup and group play. This class has the attributes: clubs, name, country, gender, list of teams and list of matches. Methods implemented:
+ **Competition(boolean cl, String n, Country co, Gender g):** Constructor.
+ **addTeam(Team t):** Add team to the competition.
+ **generateMatches():** Create random match between two different teams of the competition 
+ **simulateMatches():** Simulate a generated match
+ **printMatches():** Print the result of a match that has been simulated
+ **printGoalScorers(int k):** Print the k top goal scorers of the competition






### League Class:_
This modified class represents the type of competition league, whereas explained in the previous labs consist of playing every other team twice and the winner of each match gets three points, the lose none and if there is a tie both teams receive one point. After all games are played, the team with more points wins the league. The attributes are inherited from the Competition class and the implemented methods are:
+ **League(String n, Country c, Gender g):** Constructor.
+ **generateMatches():** Create random match between two different teams of the league 

### Cup Class:_
This new class represents the type of competition cup, this competition has the characteristic that there is always a winner, in other words there cannot be a tie. This is because the competition works with a bracket where teams play each other and the winner advances to next round and the loser is eliminated. So, in our case if there is time we add and overtime where the first team to score wins. The attributes are inherited from the Competition class in addition to the array of list of Team and array list of Match attributes. The implemented methods are:

+ **Cup(String n, Country c, Gender g):** Constructor.
+ **generateMatches():** Create random match between two different teams of the cup 
+ **simulateMatches():** Simulate generated match 
+ **printBracket():** Print bracket of the cup





### GruopPlay Class:_
This new class represents the third type of competition cup, this competition consists on a few different groups of teams where after playing the corresponding matches the top teams of each group advance to the next round and the rest are eliminated. The attributes are inherited from the Competition class in addition to the number of groups and array of League attributes. Methods:

+ **GroupPlay(String n, Country c, Gender g):** Constructor.
+ **generateMatches():** Create random match between two different teams of the same group 
+ **simulateMatches():** Simulate generated match 
+ **printTables():** Prints the tables of each group 

### NationalTeam Class:_
This new class is used to differentiate between club and national team. Since in the real world the best players of each country play together in national competitions, in this project we implement this class so that in the three different types of competition can compete either clubs or national team (in each competition all have to be of the same type). The attributes and methods  are inherited from the Team class. Implemented methods: 
+ **NationalTeam(String n, Country c, Gender g):** Constructor.
+ **addPlayer():** Add player to the national team.

### CupMatch Class:_
Since there is an addition of the Cup competition where there cannot be ties, the CupMatch class must be implemented. This class inherits the attributes and some methos from the Match class. Implemented methods:
+ **CupMatch(Team h,Team a):** Constructor.
+ **simulateMatch():** Simulate generated match but considering that now there cannot be a tie and extra time must be played

## DESCRIPTION OF ALTERNATIVE  
During this third lab there were a lot of different implementations that we had to do, and not always our first idea of how to approach them was the final one. For example in the desigining of the Competition class, the development of the addTeam method was completely different. Since we were struggling at first we tried to work with 3 different methods just for addTeam to work which was a good idea but there were problems and the main purpose was to only have the addTeam method for this purpose of adding teams to the competition. This is what it looked like: 

```
public void addTeam(Team team) {
    if (isTeamValidForCompetition(team)) {
        teams.add(team);
    } else {
        displayInvalidTeamMessage();
    }
}

public boolean isTeamValidForCompetition(Team team) {
    if (clubs) {
        return !(team instanceof NationalTeam);
    } else {
        return team instanceof NationalTeam;
    }
}

public void displayInvalidTeamMessage() {
    if (clubs) {
        System.out.println("The competition doesn't allow National Teams, only clubs.");
    } else {
        System.out.println("The competition only allows National Teams, not clubs.");
    }
}


```

## CONCLUSION
Right now the project is more advanced and complex with a lot of different classes and with subtypes of players, competitions, teams and matches which make is better. There is also a relation between the majority of the classes and with this lab we have added the inheritance concept with the new and old classes.
The current program is very expanded and complete but for the next labs we could focus on first of all defining all the print methods and completing the code and then work in  new details to improve the overall project like for example adding more types of outfielders  (strikers, midfielders and defenders).
The main issue we had with this third lab was the lack of experience working with the inheritance concept, and therefore at the start we struggled because for example we didn’t know that we had to switch some attributes from private to protected so that the inheritance worked correctly.
Overall, the project is starting to have a good shape and if we complete what we currently have and also add some more details this project will keep increasing its quality.
