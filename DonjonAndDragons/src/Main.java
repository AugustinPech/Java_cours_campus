package DonjonAndDragons.src;

import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.User;


public class Main {
    
    public static void main(String[] args) {
        User user = new User();
        Game game = new Game(user);
        game.startGame(user);
    }
}
