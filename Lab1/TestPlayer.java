public class TestPlayer {
    public static void main(String[] args) {
        // Create a new Player
        Country playerCountry = new Country("CountryName"); // Assuming you have a Country class
        Player player = new Player(true, "Alice", 25, playerCountry, 10, 15, 20, 30, 5, 8);

        // Test the methods
        System.out.println("Player Name: " + player.getName());
        System.out.println("Player Age: " + player.getAge());
        System.out.println("Is the Player Female? " + player.isFemale());

        // Update player stats
        player.update(12, 25, 35, 10, 12);

        // Print player stats
        System.out.println("Player Stats:");
        player.printStats();
    }
}
