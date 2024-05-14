package DonjonAndDragons.src.models.Game;

public class User {
    public User() {
        try {
            System.out.println("User created");
        } catch (Exception e) {
            System.out.println("Error creating user");
        }
    }
    public Game newGame() {
        try {
            System.out.println("New game started");
            Game game = new Game(this);
            return game;
        } catch (Exception e) {
            System.out.println("Error starting new game");
            return this.newGame();
        }
    }
}
