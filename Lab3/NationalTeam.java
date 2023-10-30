package Lab3;

public class NationalTeam extends Team{
    public NationalTeam(String n, Country c, Gender g){
        super(n,c,g);
    }

    public void addPlayer(Player p){
        if(p.getNationality() == country){
            playerList.add(p);
        }
        

    }
}
