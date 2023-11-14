public abstract class PlayerStats extends Player{
    protected Player player;
    protected int noMatches;

    public PlayerStats(Player p){
        super(p.gender, p.name, p.age, p.nationality);
    }

    public void updateStats(Match m){
        
    }
    public abstract void printStats();
}
