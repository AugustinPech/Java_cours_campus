package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;
import java.util.List;

import DonjonAndDragons.src.models.Game.dice.D100;
import DonjonAndDragons2.src.models.Game.Board.dice.D10;
import DonjonAndDragons2.src.models.Game.Board.dice.D20;


public class Board {

    private int size;


    private int lvlMax=0;
    private int lvlMin=0;
    private ArrayList<Room> dungeon= new ArrayList<Room>();
    final ArrayList<Room> roomBank = new ArrayList<Room>();
    private ArrayList<Integer> path = new ArrayList<Integer>();
    private D10 d10 = new D10();
    private D20 d20 = new D20();
    private D100 d100 = new D100();
    
    public Board(String difficulty) {
        this.size=10; //+some stuff
        switch (difficulty) {
            case "EASY" :
                this.setLvlMax(20);
                break;
            case "MEDIUM":
                this.setLvlMax(30);
                break;
            case "HARD":
                this.setLvlMin(2);
                this.setLvlMax(40);
                break;
        }
        for (int j = this.getLvlMin() ; j<this.getLvlMax(); j++){
            for (int i = 0 ; i < 5; i++) {
                if (i%5==0) {
                    this.roomBank.add(new GuardRoom(j));
                } else if (i%5==1) {
                    this.roomBank.add(new Volt(j));
                } else if (i%5==2) {
                    this.roomBank.add(new BossRoom(j));
                } else if (i%5==3) {
                    this.roomBank.add(new Heart(j));
                } else {
                    this.roomBank.add(new PotionRoom(j));
                }
            }
        }
        this.roomBank.add(new HallWay());
        this.roomBank.add(new DoorStep());

        this.setPath(this.createPath(difficulty));

        for (int i = 0; i < this.path.size(); i++) {
            this.dungeon.add(roomBank.get(path.get(i).intValue()));
        }
    }
    
    private ArrayList<Integer> createPath(String difficulty) {
        ArrayList<Integer> path = new ArrayList<Integer>();

        int nextRoom=0;
        switch (difficulty) {
            case "EASY" :
                nextRoom=0;
                break;
            case "MEDIUM":
                nextRoom=5;
                break;
            case "HARD":
                nextRoom=10;
                break;
        }
        for (int i =0 ; i< this.getSize();i++){
            if (i==0){
                path.add(roomBank.size()-1);//Doorstep
                path.add(roomBank.size()-2);//Halllway
            } else if (i%2==0){
                nextRoom +=1;
                path.add(nextRoom);
                nextRoom +=3;
                path.add(nextRoom);
                nextRoom+=1;
            } else {
                path.add(nextRoom);
            }
        }
        path.add(nextRoom+2);//BoosRoom
        path.add(nextRoom+3);//Heart
        return path;
    }

    public List<Room> getDungeon() {
        return dungeon;
    }
    public ArrayList<Integer> getPath() {
        return path;
    }

    public void setPath(ArrayList<Integer> path) {
        this.path = path;
    }
    public int getLvlMax() {
        return lvlMax;
    }

    public void setLvlMax(int lvlMax) {
        this.lvlMax = lvlMax;
    }
    public int getLvlMin() {
        return lvlMin;
    }

    public void setLvlMin(int lvlMin) {
        this.lvlMin = lvlMin;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
