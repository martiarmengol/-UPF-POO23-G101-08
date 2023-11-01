package Lab3;

public class LeagueMain {
    public static void main(String[] args) {
        // Create teams and add them to the League
        Team team1 = new Team("Team 1", new Country("Country A"), Gender.MALE);
        Team team2 = new Team("Team 2", new Country("Country B"), Gender.MALE);
        Team team3 = new Team("Team 3", new Country("Country C"), Gender.MALE);
        Team team4 = new Team("Team 4", new Country("Country D"), Gender.MALE);

        League league = new League(true, "League Competition", new Country("League Country"), Gender.MALE);
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);

        // Generate matches
        league.generateMatches();

        // Simulate matches
        league.simulateMatches();
    }
}
