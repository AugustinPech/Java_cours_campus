package DonjonAndDragons.src.models.Game;

public class Board {
    public int size;
    public Room[] dungeon;

    public Board(int size, Game game){
        this.size = size;
        this.createBoard();
    }
    public void createBoard(){
        this.dungeon = new Room[this.size];
        for (int i = 0; i < this.size; i++) {
            if (i==0){
                this.dungeon[i] = new Room("Hallway");
            }
            this.dungeon[i] = new Room();
        }
    }
}
