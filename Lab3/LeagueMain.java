//package Lab3;

public class LeagueMain {
    public static void main(String[] args) {
        Country countryA = new Country("Spain");
        Country countryB = new Country("Germany");
        Country countryC = new Country("Italy");
        Country countryD = new Country("France");
        Country countryE = new Country("Portugal");
        
        Team team1 = new Team("Barça", countryA, Gender.MALE);
        Team team2 = new Team("Madrid", countryB, Gender.MALE);
        Team team3 = new Team("Atletico", countryC, Gender.MALE);
        Team team4 = new Team("Valencia", countryD, Gender.MALE);

        String[] playerNames = { "Marti", "Sergi", "Joan", "Adry", "Jofre", "Guillem", "Jordi", "Rita", "Eli", "Georgina" };
        int[] playerAges = { 25, 23, 27, 22, 24, 26, 28, 29, 30, 21 };
        Gender[] playerGenders = { Gender.MALE, Gender.MALE, Gender.MALE, Gender.MALE, Gender.MALE, Gender.MIXED, Gender.MIXED, Gender.MALE, Gender.MALE, Gender.MALE };

        for (int i = 0; i < playerNames.length; i++) {
            OutFielder player = new OutFielder(playerGenders[i], playerNames[i], playerAges[i], i % 5 == 0 ? countryA
                    : (i % 5 == 1 ? countryB : (i % 5 == 2 ? countryC : (i % 5 == 3 ? countryD : countryE))));

            if (i % 5 == 0) {
                team1.addPlayer(player);
            } else if (i % 5 == 1) {
                team2.addPlayer(player);
            } else if (i % 5 == 2) {
                team3.addPlayer(player);
            } else if (i % 5 == 3) {
                team4.addPlayer(player);
            }
        }

        GoalKeeper goalie1 = new GoalKeeper(Gender.MALE, "Albert", 28, countryA);
        GoalKeeper goalie2 = new GoalKeeper(Gender.MALE, "Maria", 26, countryB);
        GoalKeeper goalie3 = new GoalKeeper(Gender.MALE, "Josep", 30, countryC);
        GoalKeeper goalie4 = new GoalKeeper(Gender.MALE, "Helena", 25, countryD);

        // Add Goalkeepers to Teams
        team1.addPlayer(goalie1);
        team2.addPlayer(goalie2);
        team3.addPlayer(goalie3);
        team4.addPlayer(goalie4);

        League league = new League(true, "League Competition", new Country("Spain"), Gender.MALE);
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);

        // Generate matches
        league.generateMatches();

        // Simulate matches
        league.simulateMatches();

        System.out.println(">>>>>>>>>>START OF THE LEAGUE<<<<<<<<<<");
        league.printMatches();

        // Print team statistics
        System.out.println(">>>>>>>>>>TEAM STATS<<<<<<<<<<");
        Competition l = (Competition) league;
        for (Team team : l.getTeams()) {
            team.printStats();
        }

        league.printTable();
        league.printGoalScorers(league.getTotalPlayers());
    }
}
