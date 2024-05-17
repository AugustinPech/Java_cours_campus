package DonjonAndDragons2.src.models.Game;

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
            Game game = new Game(this);
            System.out.println("New game started");
            return game;
        } catch (Exception e) {
            System.out.println("Error starting new game\n");
            System.out.println(e.getMessage());
            return this.newGame();
        }
    }
}
