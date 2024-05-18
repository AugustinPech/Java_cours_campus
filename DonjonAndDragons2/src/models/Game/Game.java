package DonjonAndDragons2.src.models.Game;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.Player.Playable;
import DonjonAndDragons2.src.models.Caracters.Player.Warrior;
import DonjonAndDragons2.src.models.Caracters.Player.Wizard;
import DonjonAndDragons2.src.models.Game.Board.Board;
import DonjonAndDragons2.src.models.Game.Board.Room;
import DonjonAndDragons2.src.models.Game.Exception.CaracterIsDeadException;
import DonjonAndDragons2.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons2.src.models.Game.Exception.NotConsumableException;
import DonjonAndDragons2.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons2.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons2.src.models.items.Item;

public class Game {
    private Playable player;
    private Board board;

    private Menu menu;
    private int turnNumber;
    private User user;
    private String difficulty;
    
    public Game(User user){
        this.user = user;
        this.menu = new Menu(System.in);
        this.difficulty = this.menu.getDifficulty();
        this.board = new Board(this.difficulty);
        this.player = this.playerChoosesCaracter();
        this.turnNumber = 0;
    }

    private Playable playerChoosesCaracter() {
        try {
            String classRef = this.menu.chooseCaracterMenu();
            String name = this.menu.chooseNameMenu();

            if(classRef.equals("1")){
                return new Warrior(name);
            }else if(classRef.equals("2")){
                return new Wizard(name);
            }else{
                throw new UnsupportedOperationException("Invalid class");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return this.playerChoosesCaracter();
        }
    }
    public void play () {
        try {
            boolean stopPlaying = this.win() || this.lose();
            
            while(!stopPlaying){
                this.turnNumber++;
                this.playTurn();
                stopPlaying = this.win() || this.lose();
            }

            boolean win = this.win();
            
            if(win){
                this.menu.winMenu();
            } else {
                this.menu.gameOverMenu();
            }
        } catch (PlayerIsDeadException e) {
            this.menu.gameOverMenu();
        }
    }
    
    public void playTurn() throws PlayerIsDeadException{

            ArrayList<Caracter> whosThere = this.whosThere();

            whosThere = this.upkeepPhase();
            whosThere = this.mainPhase(whosThere);

            whosThere = this.movementPhase(whosThere);
            whosThere = this.mainPhase(whosThere);

            whosThere = this.encounterPhase(whosThere);
            whosThere = this.mainPhase(whosThere);

            this.endPhase(whosThere);
            
    }

    private ArrayList<Caracter> whosThere() {
        ArrayList<Caracter> whosThere = this.board.getDungeon().get(this.player.getPosition()).getCaracters();
        if (!whosThere.contains(this.player)){            
            whosThere.add(this.player);
        }
        return whosThere;
    }


    private ArrayList<Caracter> endPhase(ArrayList<Caracter> whosThere) {
        // TODO Auto-generated method stub
        return whosThere;
    }

    private ArrayList<Caracter> encounterPhase(ArrayList<Caracter> whosThere) {
        // TODO Auto-generated method stub
        return whosThere;
    }

    private ArrayList<Caracter> movementPhase(ArrayList<Caracter> whosThere) {
        // TODO Auto-generated method stub
        return whosThere;
    }

    private ArrayList<Caracter> mainPhase(ArrayList<Caracter> whosThere) {
        String answer = this.menu.mainPhaseMenu();
        ArrayList<Caracter> initial = whosThere;
        switch (answer) {
            case "C":
                this.menu.caracterSheetMenu(this.player);
                return this.mainPhase(whosThere);
            case "I":
                whosThere.set(whosThere.indexOf(this.player),this.inventoryManager(this.player));
                return whosThere;
            case "E":
                whosThere.set(whosThere.indexOf(this.player),this.equipmentManager(this.player));
                return whosThere;
            case "Q":
                System.exit(0);
                break;
            default:
                break;
        }
        if (answer !="" && initial == whosThere) {
            return this.mainPhase(whosThere);
        } else {
            return whosThere;
        }
    }

    private Playable equipmentManager(Playable player) {
        // TODO Auto-generated method stub
        return player;
    }

    private Playable inventoryManager(Playable player) {
        String answer = this.menu.inventoryMenu(player.getInventory());
        if (answer == "" ){
            return player;
        } else if (answer == "B"){
            return player;  // Tofix
        } else if (player.getInventory().get(Integer.valueOf(answer)) instanceof Item){
            player = this.itemInteractionInventory(player.getInventory().get(Integer.valueOf(answer)));
            return player;
        } else {
            this.menu.noSuchItem(answer);
            return player;
        }
    }

    private Playable itemInteractionInventory(Item item) throws PlayerIsDeadException {
        String answer = this.menu.itemInteractionInventoryMenu(item);
        switch (answer) {
            case "E":
                try {
                    return this.player.equipItem(item);
                } catch (EquipmentFullException e) {
                    e.printStackTrace();
                    return this.itemInteractionInventory(item);
                } catch (NotEquipableException e) {
                    e.printStackTrace();
                    return this.itemInteractionInventory(item);
                }
            case "U":
                try {
                    return this.player.consumeItem(item);
                } catch (NotConsumableException e) {
                    e.printStackTrace();
                    return this.itemInteractionInventory(item);
                }
            case "D":
                this.board.getDungeon().get(this.player.getPosition()).addItem(this.player.dropItem(item));
                return this.player;
            case "B":
                return this.inventoryManager(this.player);
            default:
                return this.player;
        }
    }

    private ArrayList<Caracter> upkeepPhase() throws PlayerIsDeadException {
        ArrayList<Caracter> whosThere = this.whosThere();
        this.menu.startTurnMenu(this.turnNumber, this.player, this.board);
        this.menu.displayBoard(this.board , this.player);

        whosThere.forEach(caracter -> {
            try {caracter.upkeep();}
            catch (CaracterIsDeadException e) {
                if (caracter instanceof Playable){
                    throw new PlayerIsDeadException();
                }
                // TODO
                // this.caracterdies(caracter);
            }
        });
        return whosThere;
    }

    private boolean lose() {
        // todo
        return false;
    }

    private boolean win() {
        // todo
        return false;
    }

    public Board getBoard() {
        return board;
    }
}