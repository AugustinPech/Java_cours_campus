package DonjonAndDragons.src.models.Game;

import java.util.Collections;
import java.util.List;

public class Board {
    public int size;
    public Room[] dungeon;

    public Board(int size, Game game){
        this.size = size;
        int heart = size-1;
        int boss = size-2;
        this.dungeon = new Room[this.size];
        
        for (int i = 0; i < this.size; i++) {
                    this.dungeon[i] = new Room();
        }
        this.dungeon[0] = new Room("Doorstep", game);
        this.dungeon[1] = new Room("Hallway", game);
        this.dungeon[boss] = new Room("Boss Room", game);
        this.dungeon[heart] = new Room("Heart", game);
    }
}
