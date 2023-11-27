#ifndef _OUTFIELDER_
#define _OUTFIELDER_


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
        
        bool isHomeScorer = std::find(homeScorers.begin(), homeScorers.end(), this) != homeScorers.end();
        bool isAwayScorer = std::find(awayScorers.begin(), awayScorers.end(), this) != awayScorers.end();
        
        this->noGoals += isHomeScorer ? homeGoals : isAwayScorer ? awayGoals : 0;

        this->noTackles = rand() % 11;
        this->noPasses = rand() % 51;
        this->noShots = rand() % 6;
        this->noAssists = rand() % 11;
    }


    void printStats() {
        cout << "No Tackles: " << noTackles << endl;
        cout << "No Assists: " << noAssists << endl;
        cout << "No Passes: " << noPasses << endl;
        cout << "No Goals: " << noGoals << endl;
        cout << "No Shots: " << noShots << endl;
    }
};

#endif
