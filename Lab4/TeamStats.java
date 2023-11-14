public class TeamStats extends Team{
    protected Team t;
    protected int noMatches;
    protected int noWins;
    protected int noTies;
    protected int noLosses;
    protected int goalsScored;
    protected int goalsAgainst;

    public TeamStats(Team t){
        super(t.name,t.country,t.gender);
    }
    public int getWins(){
        return noWins;
    }

    public int getLosses(){
        return noLosses;
    }

    public int getGoalsScored(){
        return goalsScored;
    }

    public int getGoalsAgainst(){
        return goalsAgainst;
    }

    public void updateStats(Match match) {
        for (Player player : getPlayers()) {
            // Check if the player is an instance of OutFielder before casting
            if (player instanceof OutFielder) {
                OutFielder outFielder = (OutFielder) player;
                outFielder.updateStats(match);
            }
        }
    
        int homeGoals = match.getHomeGoals();
        int awayGoals = match.getAwayGoals();
    
        if (homeGoals > awayGoals) {
            noWins++;
        } else if (homeGoals < awayGoals) {
            noLosses++;
        } else {
            noTies++;
        }
    
        goalsScored += homeGoals;
        goalsAgainst += awayGoals;
    
        noMatches++;
    }

    public void printStats(){
        System.out.println(" ");
        System.out.println("Team:"+name+" stats");
        System.out.println("Matches:"+noMatches);
        System.out.println("Wins:"+noWins);
        System.out.println("Losses:"+noLosses);
        System.out.println("Tie:"+noTies);
        System.out.println("Against:"+goalsAgainst);
        System.out.println("Goals Scored:"+goalsScored);
        System.out.println(" ");
    }

    public int compareTo(Object o){
        return 0;
    }
}
