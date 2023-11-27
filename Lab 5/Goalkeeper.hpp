#ifndef _GOALKEEPER_
#define _GOALKEEPER_

#include <cstdlib>
#include <ctime>
#include <iostream>
#include "Player.hpp"
#include "Match.hpp"

class GoalKeeper : public Player{
private:
    int noSaves,noGoalsLet;

public:
    GoalKeeper(std::string name, bool g, int a, Country* nat) : Player(name, g, a, nat) {
        noSaves = 0;
        noGoalsLet = 0;
    }

    void updateStats(Match* match) override {
        srand(static_cast<unsigned int>(time(nullptr)));

        for (Player* player : match->getTeamOne()) {
            if (player == this) {
                noSaves = noSaves + rand() % (10 - match->getGoalTwo());
                noGoalsLet = noGoalsLet + match->getGoalTwo();
            } else {
                noSaves = noSaves + rand() % (10 - match->getGoalOne());
                noGoalsLet = noGoalsLet + match->getGoalOne();
            }
        }
    }

    void printStats(){
        cout << "No Saves: " << noSaves << endl;
        cout << "No Goals Let: " << noGoalsLet << endl;
    }
};


#endif
