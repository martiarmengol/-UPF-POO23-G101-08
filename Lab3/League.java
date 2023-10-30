package Lab3;

public class League extends Competition {
    public League(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);
    }    

    public void generateMatches(){
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                matches.add(new Match(team1, team2));
                matches.add(new Match(team2, team1)); 
            }
        }
    }

    public void printTable(){
        
    }


}
