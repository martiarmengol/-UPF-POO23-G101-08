package Lab3;

public class GroupPlayMain {
    public static void main(String[] args) {
        Country countryA = new Country("Spain");
        Country countryB = new Country("Germany");
        Country countryC = new Country("Italy");
        Country countryD = new Country("France");
        Country countryE = new Country("Portugal");
        
        Team team1 = new Team("Barça", countryA, Gender.MALE);
        Team team2 = new Team("Madrid", countryB, Gender.FEMALE);
        Team team3 = new Team("Atletico", countryC, Gender.MALE);
        Team team4 = new Team("Valencia", countryD, Gender.FEMALE);
        Team team5 = new Team("Rayo", countryA, Gender.MALE);
        Team team6 = new Team("Juevntus", countryB, Gender.FEMALE);
        Team team7 = new Team("Bayern", countryC, Gender.MALE);
        Team team8 = new Team("Elche", countryD, Gender.FEMALE);

        String[] playerNames = { "Marti", "Sergi", "Joan", "Adry", "Jofre", "Guillem", "Jordi", "Rita", "Eli", "Georgina" };
        int[] playerAges = { 25, 23, 27, 22, 24, 26, 28, 29, 30, 21 };
        Gender[] playerGenders = { Gender.MALE, Gender.FEMALE, Gender.MALE, Gender.FEMALE, Gender.MIXED, Gender.MIXED, Gender.MIXED, Gender.FEMALE, Gender.MALE, Gender.MIXED };

        for (int i = 0; i < playerNames.length; i++) {
            Player player = new Player(playerGenders[i], playerNames[i], playerAges[i], i % 8 == 0 ? countryA
                    : (i % 8 == 1 ? countryB : (i % 8 == 2 ? countryC : (i % 8 == 3 ? countryD
                            : (i % 8 == 4 ? countryE : (i % 8 == 5 ? countryA : (i % 8 == 6 ? countryB : countryC)))))));
        
            if (i % 8 == 0) {
                team1.addPlayer(player);
            } else if (i % 8 == 1) {
                team2.addPlayer(player);
            } else if (i % 8 == 2) {
                team3.addPlayer(player);
            } else if (i % 8 == 3) {
                team4.addPlayer(player);
            } else if (i % 8 == 4) {
                team5.addPlayer(player);
            } else if (i % 8 == 5) {
                team6.addPlayer(player);
            } else if (i % 8 == 6) {
                team7.addPlayer(player);
            } else if (i % 8 == 7) {
                team8.addPlayer(player);
            }
        }
        

        GoalKeeper goalie1 = new GoalKeeper(Gender.MALE, "Albert", 28, countryA);
        GoalKeeper goalie2 = new GoalKeeper(Gender.FEMALE, "Maria", 26, countryB);
        GoalKeeper goalie3 = new GoalKeeper(Gender.MALE, "Josep", 30, countryC);
        GoalKeeper goalie4 = new GoalKeeper(Gender.FEMALE, "Helena", 25, countryD);
        GoalKeeper goalie5 = new GoalKeeper(Gender.MALE, "Pau", 28, countryA);
        GoalKeeper goalie6 = new GoalKeeper(Gender.FEMALE, "Alex", 26, countryB);
        GoalKeeper goalie7 = new GoalKeeper(Gender.MALE, "Pep", 30, countryC);
        GoalKeeper goalie8 = new GoalKeeper(Gender.FEMALE, "Jan", 25, countryD);

        // Add Goalkeepers to Teams
        team1.addPlayer(goalie1);
        team2.addPlayer(goalie2);
        team3.addPlayer(goalie3);
        team4.addPlayer(goalie4);
        team5.addPlayer(goalie5);
        team6.addPlayer(goalie6);
        team7.addPlayer(goalie7);
        team8.addPlayer(goalie8);

        GroupPlay groupPlay = new GroupPlay(true, "Champions League", countryA, Gender.MALE);

        groupPlay.addTeam(team1);
        groupPlay.addTeam(team2);
        groupPlay.addTeam(team3);
        groupPlay.addTeam(team4);
        groupPlay.addTeam(team5);
        groupPlay.addTeam(team6);
        groupPlay.addTeam(team7);
        groupPlay.addTeam(team8);

        // Create and add groups (instances of League) to the GroupPlay
        League groupA = new League(true, "Group A", new Country("Group A Country"), Gender.MALE);
        League groupB = new League(true, "Group B", new Country("Group B Country"), Gender.MALE);
        groupPlay.addGroup(groupA);
        groupPlay.addGroup(groupB);

        // Generate matches within each group
        groupPlay.generateMatches();
        
        // Simulate matches within each group
        groupPlay.simulateMatches();
        groupPlay.printMatches();
        groupPlay.printTables();
    }
}
