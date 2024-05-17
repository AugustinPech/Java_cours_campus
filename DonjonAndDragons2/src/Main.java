package DonjonAndDragons2.src;

import DonjonAndDragons2.src.models.Game.Game;
import DonjonAndDragons2.src.models.Game.User;


public class Main {   

    public static void main(String[] args) {
        User user = new User();
        Game game = user.newGame();
        game.play();
    }
}