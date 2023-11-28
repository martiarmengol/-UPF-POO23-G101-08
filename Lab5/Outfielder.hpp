#ifndef _OUTFIELDER_
#define _OUTFIELDER_

#include <iostream>
#include <cstdlib> 
#include <ctime>   
#include "Player.hpp"
#include "Match.hpp"

class Outfielder : public Player {
private:
    int noTackles, noAssists, noPasses, noGoals, noShots;

public:
    Outfielder(std::string name, bool g, int a, Country* nat) : Player(name, g, a, nat) {
        noTackles = 0;
        noAssists = 0;
        noPasses = 0;
        noGoals = 0;
        noShots = 0;
    }

    void updateStats(Match *m) {
        srand(static_cast<unsigned int>(time(nullptr)));

        int homeGoals = m->getGoalOne();
        int awayGoals = m->getGoalTwo();
        const std::list<Player *> &homeScorers = m->getScorersOne();
        const std::list<Player *> &awayScorers = m->getScorersTwo();

        bool isHomeScorer = false;
        bool isAwayScorer = false;

        for (const Player* scorer : homeScorers) {
            if (scorer == this) {
                isHomeScorer = true;
                break;
            }
        }

        for (const Player* scorer : awayScorers) {
            if (scorer == this) {
                isAwayScorer = true;
                break;
            }
        }

        this->noGoals += isHomeScorer ? homeGoals : isAwayScorer ? awayGoals : 0;

        this->noTackles = rand() % 8+1;
        this->noPasses = rand() % 51+1;
        this->noShots = rand() % 6+1;
        this->noAssists = rand() % 4+1;
    }


    void printStats() {
        std::cout << "Stats for " << this->getName() << std::endl;
        std::cout << "No Tackles: " << noTackles << std::endl;
        std::cout << "No Assists: " << noAssists << std::endl;
        std::cout << "No Passes: " << noPasses << std::endl;
        std::cout << "No Goals: " << noGoals << std::endl;
        std::cout << "No Shots: " << noShots << std::endl;
    }
};

#endif
