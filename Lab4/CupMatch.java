//package Lab3;

import java.util.Random;

public class CupMatch extends Match{
    public CupMatch(Team h,Team a){
        super(h, a);
    }

    public void simulateMatch(){
        Random random = new Random();
    
        // Simulate the match
        int homeGoals = random.nextInt(6);  
        int awayGoals = random.nextInt(6);  
        
        if(homeGoals == awayGoals){
            int overtimeWinner = random.nextInt(2);
            if(overtimeWinner == 0){
                homeGoals++;
            }else{
                awayGoals++;
            }
        }
        
        for (int i = 0; i < homeGoals; i++) {
            int indexHome = random.nextInt(homeTeam.getPlayers().size());
            homeScorers.add(homeTeam.getPlayers().get(indexHome));
        }

        for (int i = 0; i < awayGoals; i++) {
            int indexAway = random.nextInt(awayTeam.getPlayers().size());
            awayScorers.add(awayTeam.getPlayers().get(indexAway));
        }

        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }
}
