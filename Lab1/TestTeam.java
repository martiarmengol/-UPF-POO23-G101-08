public class TestTeam {
    public static void main(String[] args) {
        // Create a new Team
        Country playerCountry = new Country("Spain"); 
        Team team = new Team("TeamName", playerCountry, Gender.MIXED, 0, 0, 0, 0, 0, 0);

        // Create some players
        Player player1 = new Player(true, "Alice", 25, playerCountry, 10, 15, 20, 30, 5, 8);
        Player player2 = new Player(false, "Bob", 30, playerCountry, 15, 20, 25, 35, 10, 12);

        // Add players to the team
        team.addPlayer(player1);
        team.addPlayer(player2);

        // Test the team's methods
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team Country: " + team.getCountry().getName());
        System.out.println("Team Gender: " + team.getGender());

        // Play a match
        team.playMatch(3, 2);

        // Print team statistics
        System.out.println("Team Stats:");
        team.printStats();
    }
}
