#ifndef _PLAYER_
#define _PLAYER_

#include <stdio.h>
#include <string.h>

abstract class Player{
    private:
    bool fmeale;
    string name;
    int age,noMatches;
    Coutry nationality;
    
    public:
        Player(string name, bool g,int a, Coutry nat){
            this->name=name;
            this->fmeale=g;
            this->age=a;
            this->nationality=nat;
            this->noMatches=0;
        }
        int getNoMatches(){
            return this->noMatches;
        }

        int getAge(){
            return this->age;
        }

        string getName(){
            return this->name;
        }

        Coutry getNationality(){
            return this->nationality;
        }

        bool equals(Object o){

        }

        abstract void updateStats(Match m);
        abstract void printStats();
    

}

#endif