#include "Goalkeeper.hpp"
#include "Outfielder.hpp"

int main() {
    // Create countries
    Country* country1 = new Country("Country1");
    Country* country2 = new Country("Country2");

    // Create outfielders
    Outfielder* outfielder1 = new Outfielder("Outfielder1", false, 25, country1);
    Outfielder* outfielder2 = new Outfielder("Outfielder2", true, 28, country2);

    // Create goalkeepers
    Goalkeeper* goalkeeper1 = new Goalkeeper("Goalkeeper1", false, 30, country1);
    Goalkeeper* goalkeeper2 = new Goalkeeper("Goalkeeper2", true, 32, country2);

    // Create teams and add players
    Team* team1 = new Team("Team1", country1, Team::MALE);
    Team* team2 = new Team("Team2", country2, Team::FEMALE);

    team1->addPlayer(outfielder1);
    team1->addPlayer(goalkeeper1);

    team2->addPlayer(outfielder2);
    team2->addPlayer(goalkeeper2);

    // Create a match between the two teams
    Match* match = new Match(team1, team2);

    // Simulate the match and print the result
    match->simulateMatch();
    match->printMatch();

    // Update the statistics of each player
    outfielder1->updateStats(match);
    outfielder2->updateStats(match);
    goalkeeper1->updateStats(match);
    goalkeeper2->updateStats(match);

    // Print the statistics of each player
    outfielder1->printStats();
    outfielder2->printStats();
    goalkeeper1->printStats();
    goalkeeper2->printStats();

    // Cleanup: Delete dynamically allocated objects
    delete country1;
    delete country2;
    delete outfielder1;
    delete outfielder2;
    delete goalkeeper1;
    delete goalkeeper2;
    delete team1;
    delete team2;
    delete match;

    return 0;
}
