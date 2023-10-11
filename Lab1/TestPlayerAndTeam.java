public class TestPlayerAndTeam {
    public static void main(String[] args) {
        // Create some countries
        Country germany = new Country("Germany");
        Country france = new Country("France");

        // Create some players
        Player player1 = new Player(true, "Alice", 25, germany);
        Player player2 = new Player(false, "Bob", 30, france);
        Player player3 = new Player(true, "Eve", 28, germany);

        // Create teams
        Team team1 = new Team("Team A", germany, Gender.FEMALE);
        Team team2 = new Team("Team B", france, Gender.MALE);

        // Add players to teams
        team1.addPlayer(player1);
        team1.addPlayer(player3);
        team2.addPlayer(player2);

        // Print team information
        System.out.println("Team 1: " + team1.getName() + " from " + team1.getCountry().getName() + ", Gender: " + team1.getGender());
        System.out.println("Team 2: " + team2.getName() + " from " + team2.getCountry().getName() + ", Gender: " + team2.getGender());

        // Play matches
        team1.playMatch(2, 1);
        team2.playMatch(1, 2);

        // Print team and player statistics
        System.out.println("");
        System.out.println("Team 1 Statistics:");
        team1.printStats();

        System.out.println("");
        System.out.println("Team 2 Statistics:");
        team2.printStats();

        System.out.println("");
        System.out.println("Player 1 Statistics:");
        player1.printStats();

        System.out.println("");
        System.out.println("Player 2 Statistics:");
        player2.printStats();
    }
}
