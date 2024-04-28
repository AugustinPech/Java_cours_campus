package DonjonAndDragons.src.models.Game;

public class Board {
    public int size;
    public Room[] dungeon;

    public Board(int size, Game game){
        this.size = size;
        this.dungeon = new Room[this.size];
        for (int i = 0; i < this.size; i++) {
            switch (i) {
                case 0 :
                    this.dungeon[i] = new Room("Doorstep", game);
                    break;
                case 1 :
                    this.dungeon[i] = new Room("Hallway", game);
                    break;
                default :
                    this.dungeon[i] = new Room();
            }

        }
    }
}
