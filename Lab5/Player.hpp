#ifndef _PLAYER_
#define _PLAYER_

#include <stdio.h>
#include <string.h>
#include "Country.hpp"
class Match;

class Player{

protected:
    bool female;
    std::string name;
    int age,noMatches;
    Country* nationality;
    
public:
    Player(std::string name, bool g, int a, Country* nat) : name(name), female(g), age(a), nationality(nat), noMatches(0) {}
    /*Player(string name, bool g,int a, Coutry nat){
        this->name=name;
        this->female=g;
        this->age=a;
        this->nationality=nat;
        this->noMatches=0;
    }*/

    bool isFemale(){
        return this->female;
    }

    int getNoMatches(){
        return this->noMatches;
    }

    int getAge(){
        return this->age;
    }

    std::string getName(){
        return this->name;
    }

    Country * getNationality(){
        return this->nationality;
    }

    /*bool equals(const o){
        
    }*/

    virtual void updateStats(Match * m)=0;
    virtual void printStats()=0;
    

};

#endif