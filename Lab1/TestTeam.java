public class TestTeam {
    public static void main(String[] args) {
        
        Country germany = new Country("Germany");
        Country france = new Country("France");

        Player player1 = new Player(true, "Alice", 25, germany);
        Player player2 = new Player(false, "Bob", 30, france);
        Player player3 = new Player(true, "Eve", 28, germany);

        
        Team team1 = new Team("Team A", germany, Gender.FEMALE);
        Team team2 = new Team("Team B", france, Gender.MALE);

        
        team1.addPlayer(player1);
        team1.addPlayer(player3);
        team2.addPlayer(player2);


        System.out.println("Team 1: " + team1.getName() + " from " + team1.getCountry().getName() + ", Gender: " + team1.getGender());
        System.out.println("Team 2: " + team2.getName() + " from " + team2.getCountry().getName() + ", Gender: " + team2.getGender());
        System.out.println("/////////////////");
        
        team1.playMatch(2, 1);
        team2.playMatch(1, 2);

        
        System.out.println("Team 1 Statistics:");
        team1.printStats();
        System.out.println("");
        System.out.println("Team 2 Statistics:");
        team2.printStats();
    }
}
