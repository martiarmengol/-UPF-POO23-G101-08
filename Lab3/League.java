//package Lab3;

public class League extends Competition {
    public League(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);
    }    

    public void generateMatches(){
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                matches.add(new Match(team1, team2, null));
                matches.add(new Match(team2, team1, null)); 
            }
        }
    }

    public void printTable() {
        System.out.println("League Table for " + getName());
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s%n", "Team", "Wins", "Losses", "Goals For", "Goals Against");
        System.out.println("---------------------------------------------------------");
        for (Team team : teams) {
            System.out.printf("%-20s %-10d %-10d %-10d %-10d%n", team.getName(), team.getWins(), team.getLosses(), team.getGoalsScored(), team.getGoalsAgainst());
        }
        System.out.println("---------------------------------------------------------");
    }
    


}
