package Lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Cup extends Competition {
    Random random = new Random();
    int n = random.nextInt();
    private ArrayList<Team>[] tr = new ArrayList[n];
    private ArrayList<Match>[] mr = new ArrayList[n];

    public Cup(boolean s,String n, Country c,Gender g ){
        super(s,n,c,g);
    }

    public void generateMatches(){
        
    }

    public void simulateMatches(){

    }

    public void printBraket(){

    }
}
