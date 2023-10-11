public class TestPlayer {
        public static void main(String[] args) {
            Country germany = new Country("Germany");
            Country france = new Country("France");
    
            Player player1 = new Player(true, "Alice", 25, germany);
            Player player2 = new Player(false, "Bob", 30, france);
    
            player1.update(10, 5, 15, 3, 8);
            player2.update(8, 7, 12, 2, 6);
    
            System.out.println(player1.getName() + " is " + player1.getAge() + " years old and " + (player1.isFemale()? "female" : "male") + ". She is from " + player1.getNationality().getName() + ".");
            System.out.println(player2.getName() + " is " + player2.getAge() + " years old and " + (player2.isFemale()? "female" : "male") + ". He is from " + player2.getNationality().getName() + ".");
            
            System.out.println("Player 1: "+player1.getName());
            player1.printStats();
            System.out.println("");
            System.out.println("Player 2: "+player2.getName());
            player2.printStats();
        }
}
