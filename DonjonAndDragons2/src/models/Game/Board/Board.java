package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private int size;
    private ArrayList<Room> dungeon= new ArrayList<Room>();
    
    public Board(String difficulty) {
        this.size=100;
        for (int i = 0 ; i <size+2; i++) {
            if (i==101){
                this.dungeon.add(new DoorStep());
            } else if (i==100) {
                this.dungeon.add(new HallWay());
            } else if (i<20) {
                this.dungeon.add(new GuardRoom(i%20));
            } else if (i<40) {
                this.dungeon.add(new Volt(i%20));
            } else if (i<60) {
                this.dungeon.add(new BossRoom(i%20));
            } else if (i<80) {
                this.dungeon.add(new Heart(i%20));
            } else {
                this.dungeon.add(new PotionRoom(i%20));
            }
        }
    }
    
    public List<Room> getDungeon() {
        return dungeon;
    }
}
