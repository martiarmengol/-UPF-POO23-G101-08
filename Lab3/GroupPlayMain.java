package Lab3;

public class GroupPlayMain {
    public static void main(String[] args) {
        // Create teams and add them to the GroupPlay
        Team team1 = new Team("Team 1", new Country("Country A"), Gender.MALE);
        Team team2 = new Team("Team 2", new Country("Country B"), Gender.MALE);
        Team team3 = new Team("Team 3", new Country("Country C"), Gender.MALE);
        Team team4 = new Team("Team 4", new Country("Country D"), Gender.MALE);

        GroupPlay groupPlay = new GroupPlay(true, "GroupPlay Competition", new Country("GroupPlay Country"), Gender.MALE);

        groupPlay.addTeam(team1);
        groupPlay.addTeam(team2);
        groupPlay.addTeam(team3);
        groupPlay.addTeam(team4);

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
    }
}
