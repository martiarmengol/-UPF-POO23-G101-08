//package Lab3;

import java.util.ArrayList;
import java.util.List;

public class LeagueMain {
    public static void main(String[] args) {
        Country[] countries = {
            new Country("Spain"), new Country("Germany"), new Country("Italy"), new Country("France"),
            new Country("Portugal"), new Country("England"), new Country("Netherlands"), new Country("Brazil"),
            new Country("Argentina"), new Country("Belgium"), new Country("Uruguay"), new Country("Croatia"),
            new Country("Mexico"), new Country("Russia"), new Country("Japan"), new Country("Australia"),
            new Country("Canada"), new Country("South Korea"), new Country("USA")
        };
        
        
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String teamName = "Team " + (i + 1);
            Country teamCountry = countries[i % countries.length];
            Gender teamGender = i % 2 == 0 ? Gender.MALE : Gender.MIXED;

            Team team = new Team(teamName, teamCountry, teamGender);

            
            for (int j = 1; j <= 10; j++) {
                String playerName = "Player " + j;
                int playerAge = 20 + j;
                Gender playerGender = j % 2 == 0 ? Gender.MALE : Gender.FEMALE;

                OutFielder outfielder = new OutFielder(playerGender, playerName, playerAge, teamCountry);
                team.addPlayer(outfielder);
            }

            
            GoalKeeper goalie = new GoalKeeper(teamGender, "Goalie" + (i + 1), 25 + i, teamCountry);
            team.addPlayer(goalie);

            teams.add(team);
        }

        // Create a league
        League league = new League(true, "Super League", new Country("International"), Gender.MALE);
        league.setTeams(teams);

        // Generate matches
        league.generateMatches();

        // Simulate matches
        league.simulateMatches();

        System.out.println(">>>>>>>>>>START OF THE LEAGUE<<<<<<<<<<");
        league.printMatches();

        // Print team statistics
        System.out.println(">>>>>>>>>>TEAM STATS<<<<<<<<<<");
        for (Team team : league.getTeams()) {
            team.printStats();
        }

        league.printTable();
        league.printTopGoalScorers(league.getTotalPlayers());
    }
}
