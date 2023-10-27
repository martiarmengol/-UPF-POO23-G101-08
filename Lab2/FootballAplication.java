package Lab2;

public class FootballAplication {
    public static void main(String[] args) {
        Country countryA = new Country("Spain");
        Country countryB = new Country("Germany");
        Country countryC = new Country("Italy");
        Country countryD = new Country("France");
        Country countryE = new Country("Portugal");
    
        League league = new League("Sample League", countryA, Gender.MIXED);

        
        Team team1 = new Team("Barça", countryA, Gender.MALE);
        Team team2 = new Team("Madrid", countryB, Gender.FEMALE);
        Team team3 = new Team("Atletico", countryC, Gender.MALE);
        Team team4 = new Team("Valencia", countryD, Gender.FEMALE);
        Team team5 = new Team("Sevilla", countryE, Gender.MALE);

        String[] playerNames = { "Marti", "Sergi", "Joan", "Adry", "Jofre", "Guillem", "Jordi", "Rita", "Eli", "Georgina" };
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
        System.out.println(">>>>>>>>>>START OF THE LEAGUE<<<<<<<<<<");
        System.out.println(" ");
        league.printMatches();

        // Print team statistics
        for (Team team : league.getTeams()) {
            team.printStats();
        }
        
    }
}
