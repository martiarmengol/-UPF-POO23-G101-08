package Lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GroupPlay extends Competition {
    private int noGroups;
    private ArrayList<League> groups = new ArrayList<>();

    public GroupPlay(boolean s,String n, Country c, Gender g){
        super(s,n,c,g);
        groups = new ArrayList<>();
    }

    public void generateMatches(){
        for(League group : groups){
            group.generateMatches();
        }
    }

    public void simulateMatches(){
        for(League group : groups){
            group.simulateMatches();;
        }
    }

    public void printTables(){

    }
}
