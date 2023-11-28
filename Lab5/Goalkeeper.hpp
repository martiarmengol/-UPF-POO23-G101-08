#ifndef _GOALKEEPER_
#define _GOALKEEPER_

#include <cstdlib>
#include <ctime>
#include <iostream>
#include "Player.hpp"
#include "Match.hpp"

class Goalkeeper : public Player{
private:
    int noSaves,noGoalsLet;

public:
    Goalkeeper(std::string name, bool g, int a, Country* nat) : Player(name, g, a, nat) {
        noSaves = 0;
        noGoalsLet = 0;
    }

    void updateStats(Match* match) override {
        srand(static_cast<unsigned int>(time(nullptr)));

        bool isTeamOneGoalkeeper = match->getTeamOne()->hasPlayer(this);

            // Update noSaves randomly
            noSaves += rand() % (5 + 1);

            // Update noGoalsLet with the number of goals scored by the other team
            if (isTeamOneGoalkeeper) {
                noGoalsLet += match->getGoalTwo();
            } else {
                noGoalsLet += match->getGoalOne();
            }

    }

    void printStats(){
        std::cout << "Stats for " << getName() << ": " << std::endl;
        std::cout << "No Saves: " << noSaves << std::endl;
        std::cout << "No Goals Let: " << noGoalsLet << std::endl;
    }
};


#endif