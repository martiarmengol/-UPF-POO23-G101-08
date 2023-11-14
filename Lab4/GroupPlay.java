//package Lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GroupPlay extends Competition {
    private int noGroups;
    private ArrayList<League> groups = new ArrayList<>();

    public GroupPlay(boolean s,String n, Country c, Gender g,int nG){
        super(s,n,c,g);
        noGroups = nG;
        groups = new ArrayList<>();
    }

    public void addGroup(League l){
        groups.add(l);
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

    public void printMatches() {
        for (League group : groups) {
            System.out.println("Matches for Group: " + group.getName());
            group.printMatches();
            System.out.println();
        }
    }

    public void printTables() {
        for (League group : groups) {
            group.printTable();
        }
    }
}
