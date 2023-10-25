package Lab2;

public class App {
    public static void main(String[] args) {
        Country countryA = new Country("Spain");
        Country countryB = new Country("Germany");
        Country countryC = new Country("Italy");
        Country countryD = new Country("France");
        Country countryE = new Country("Portugal");
        // Create a league
        League league = new League("Sample League", countryA, Gender.MIXED);

        
        Team team1 = new Team("Team A", countryA, Gender.MALE);
        Team team2 = new Team("Team B", countryB, Gender.FEMALE);
        Team team3 = new Team("Team C", countryC, Gender.MALE);
        Team team4 = new Team("Team D", countryD, Gender.FEMALE);
        Team team5 = new Team("Team E", countryE, Gender.MALE);

        String[] playerNames = { "Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6", "Player 7", "Player 8", "Player 9", "Player 10" };
        int[] playerAges = { 25, 23, 27, 22, 24, 26, 28, 29, 30, 21 };
        Gender[] playerGenders = { Gender.MALE, Gender.FEMALE, Gender.MALE, Gender.FEMALE, Gender.MIXED, Gender.MIXED, Gender.MIXED, Gender.FEMALE, Gender.MALE, Gender.MIXED };

        for (int i = 0; i < playerNames.length; i++) {
            Player player = new Player(playerGenders[i], playerNames[i], playerAges[i], i % 5 == 0 ? countryA
                    : (i % 5 == 1 ? countryB : (i % 5 == 2 ? countryC : (i % 5 == 3 ? countryD : countryE))));

            if (i % 5 == 0) {
                team1.addPlayer(player);
            } else if (i % 5 == 1) {
                team2.addPlayer(player);
            } else if (i % 5 == 2) {
                team3.addPlayer(player);
            } else if (i % 5 == 3) {
                team4.addPlayer(player);
            } else {
                team5.addPlayer(player);
            }
        }

        // Add teams to the league
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);
        league.addTeam(team5);

        // Generate matches
        league.generateMatches();

        // Simulate matches
        league.simulateMatches();

        // Print match details
        league.printMatches();

        // Print team statistics
        System.out.println("Nigger");
        for (Team team : league.getTeams()) {
            team.printStats();
        }

        
    }
}
