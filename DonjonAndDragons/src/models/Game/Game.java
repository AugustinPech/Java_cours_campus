package DonjonAndDragons.src.models.Game;

import java.util.Map;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Caracters.Player.Warrior;
import DonjonAndDragons.src.models.Caracters.Player.Wizard;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons.src.models.Game.Exception.NotUseAbleException;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.Game.dice.D100;
import DonjonAndDragons.src.models.Game.dice.Dice;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.usables.Corps;

public class Game {
    public Player player;
    public Board board;
    public Menu menu;
    private int turnNumber;
    private User user;
    private String difficulty;
    private Dice dice =new D100();
    /**
     * Constructs a new Game object.
     * 
     * @param user the User object representing the player of the game
     */
    public Game(User user) {
        this.user = user;
        this.menu = new Menu();
        String answer = this.menu.startMenu(user);
        this.difficulty = this.menu.chooseDifficultyMenu();
        this.userBecomesPlayer(user, answer);
        switch (difficulty) {
            case "1" :
                this.board = new Board(10);
                this.board.setDungeon();
                break;
            case "2" :
                this.board = new Board("normal");
                this.board.setDungeon();
                break;
            case "3" :
                this.board = new Board("hard");
                this.board.setDungeon();
                break;
        }
    }
    public void userBecomesPlayer(User user, String answer){
        switch (answer) {
            case "n": 
                this.menu.leaveGameMenu();
                break;
            case "y":
                this.userJoinsGame(user);
                break;
            case "":
                this.userJoinsGame(user);
                break;
            default:
                System.out.println("Invalid input: " + answer);
                this.menu.wantToPlay();
        } 
    }
    /**
     * Allows a user to join the game.
     * 
     * @param user [User] the user who wants to join the game
     */
    public void userJoinsGame(User user) {
            String[] answer = this.menu.joiningGameMenu(user, this);
            Caracter caracter = this.createCaracter(answer);
            this.addPlayer((Player) caracter);
            this.menu.joinedGame(this.player);
    }
    /**
     * create a caracter for the player.
     * @param answerFromMenu [String[]] the answer from the menu
     */
    public Caracter createCaracter(String[] answerFromMenu) {
        try {
            String className = answerFromMenu[0];
            String charName = answerFromMenu[1];
            switch (className){
                case "1":
                    return new Warrior(charName, this);
                case "2":
                    return new Wizard(charName,  this);
                case "3":
                    return new Warrior(3);
                default:
                    throw new IllegalArgumentException("Invalid input: " + className);
        }
        } catch (IllegalArgumentException e) {
                this.menu.exceptionMenu(e);
                return this.createCaracter(answerFromMenu);
        }
    }
    public void addPlayer(Player player){
        this.player = player;
    }
    public void gameIsLost(Caracter caracter){
        caracter.die(this.board.getDungeon()[caracter.getPosition()], this.player); 
        this.player=null;
        this.menu.youDiedMenu(this, caracter);
        this.gameOver();
    }
    private void gameOver() {
        String answer = this.menu.gameOverMenu();
        switch (answer) {
            case "y":
                this.user.newGame().startGame(this.user);
                break;
            case "n":
                break;
            default:
                this.user.newGame().startGame(this.user);
        }
    }
    public void startGame(User user) {
        try {
            int totalLife = this.player.getStats().getLifePoints();
            boolean playerStillPlaying = true;
            boolean win = false;
            boolean lost = false;
            boolean playing = playerStillPlaying && !win && !lost;
            int i=0;
            this.setTurnNumber(i);
            while (playing) {
                
                this.menu.upKeepMenu(player, this);
                String playerChoice = this.playerTakesTurn(this.player);
                this.npcTakesTurn(this.player);
                this.playerMayLevelUp(this.player);
                
                playerStillPlaying = (playerChoice == "stillPlaying");
                totalLife = this.player.getStats().getLifePoints();
                win = this.isWin();
                lost = this.isLost(totalLife);
                playing = playerStillPlaying && !win && !lost;
                
                i++;
                this.setTurnNumber(i);
            }
            if (win) {
                this.menu.winMenu();
            }
            if (lost){
                this.gameIsLost(player);
            }
        } catch (PlayerIsDeadException e) {
            this.gameIsLost(this.player);
        }
    }
    private boolean isLost(int totalLife) {
        if (totalLife <= 0) {
            return true;
        }
        return false;
    }
    private boolean isWin() {
        boolean bool = true;
        for (Room room : this.board.getDungeon()) {
            if (room.getNPC().length != 0) {
                bool &= false;
            }
        }
        return bool;
    }
    private void playerMayLevelUp(Player player) {
        int exp =player.getStats().getExperience();
        if (exp > 10) {
            player.levelUp();
            this.menu.levelUpMenu(player);
        }
    }
    private void setTurnNumber(int i) {
        this.turnNumber = i;
    }
    private void npcTakesTurn(Player player) {
        Room room = this.board.getDungeon()[player.getPosition()];
            for (NPC npc : room.getNPC()) {
                if (npc != null && npc.getIsOstile()) {
                    Map fightOuput = npc.attack(player, board);
                    this.menu.fightResultMenu(fightOuput);
                }
            }
    }
    private String playerTakesTurn(Player player) throws PlayerIsDeadException {
        if (player.getStats().getLifePoints() <= 0) {
            throw new PlayerIsDeadException();
        }
        int oldPosition = player.getPosition();

        String playerChoice = "stillPlaying";
        
        String answer=this.menu.beginningOfTurnMenu(player, this.turnNumber);
            switch (answer) {
                case "K":
                    player.move("forward", this.board.getDice().rollDie());
                    break;
                case "W":
                    playerChoice = this.menu.leaveGameMenu();
                    break;
                case "I":
                    this.board.nPCAreOstile();
                    player.move("forward", this.board.getDice().rollDie());
                    break;
                case "M":
                    this.playerMoves(player);
                    break;
                case "A":
                    this.caracterFight(player);
                    break;
                case "U":
                    return this.inventoryManager();
                case "C":
                    this.menu.spriteAndStatsShow(player);
                    return this.playerTakesTurn(player);
                case "E":
                    return this.equipmentManager();
                case "L":
                    this.playerSearchesRoom(player, this.board.getDungeon()[player.getPosition()]);
                    break;
                default:
                    System.out.println("Invalid input: " + answer);
                    this.menu.upKeepMenu(player, this);
            }
        if (player.getPosition() != oldPosition){
            this.playerEntersRoom(player, this.board.getDungeon()[player.getPosition()]);
        }
        return playerChoice;
    }
    private String inventoryManager() throws PlayerIsDeadException {
        try{
            String answer = this.menu.inventoryMenu(this.player);
            String answer2= "";

            switch (answer) {
                case "B":
                    return this.playerTakesTurn(this.player);
                default:
                    if (this.player.getInventory()[Integer.valueOf(answer)] != null){
                        answer2 = this.menu.itemInIventoryMenu(this.player, Integer.valueOf(answer));
                    } else {
                        this.menu.noSuchItemInInventoryMenu();
                        return this.inventoryManager();
                    }
                switch (answer2) {
                    case "B":
                        return this.inventoryManager();
                    case "D":
                        this.player.dropItem(Integer.valueOf(answer), this.board.getDungeon()[this.player.getPosition()]);
                        return this.playerTakesTurn(this.player);
                    case "E":
                        this.player.equipItem(Integer.valueOf(answer));
                        return this.playerTakesTurn(this.player);
                    case "U":
                        Item [] resultOfUse = this.playerUseItem(Integer.valueOf(answer));
                        if (resultOfUse != null) {
                            for (Item item : resultOfUse) {
                                this.board.getDungeon()[this.player.getPosition()].addItem(item);
                            }
                        }
                        return this.playerTakesTurn(this.player);
                    default:
                        System.out.println("Invalid input: " + answer2);
                        return this.inventoryManager();
                }
            }
        } catch (NotEquipableException e) {
            this.menu.exceptionMenu(e);
            return this.inventoryManager();
        } catch (NotUseAbleException e) {
            this.menu.exceptionMenu(e);
            return this.inventoryManager();
        } catch (EquipmentFullException e) {
            this.menu.exceptionMenu(e);
            return this.inventoryManager();
        }
    }
    private Item[] playerUseItem(Integer indexOfItemInInventory) throws NotUseAbleException, PlayerIsDeadException {
        String answer = "";
        Item [] resultOfUse = null;
        if (this.player.getInventory()[indexOfItemInInventory] instanceof Corps) {
            answer = this.menu.wishToUseCorpsMenu();
        } else {
            answer = "notCorps";
        }
        switch (answer) {
            case "": 
                this.inventoryManager();
                break;
            case "N":
                this.inventoryManager();
                break;
            case "Y":
                resultOfUse = this.player.useItem(indexOfItemInInventory);
                this.menu.defileCorpseMenu();
                break;
            case "notCorps":
                resultOfUse = this.player.useItem(indexOfItemInInventory);
                break;
        }
        return resultOfUse;

    }
    private String equipmentManager()  throws PlayerIsDeadException {
        try{
            String answer = this.menu.equipmentMenu(this.player);
            String answer2= "";

            switch (answer) {
                case "B":
                    return this.playerTakesTurn(this.player);
                default:
                    answer2 = this.menu.itemInEquipmentMenu(this.player, Integer.valueOf(answer));
            }
            switch (answer2) {
                case "B":
                    return this.equipmentManager();
                case "U":
                    this.player.unEquip(Integer.valueOf(answer), this.board.getDungeon()[this.player.getPosition()]);
                    return this.playerTakesTurn(this.player);
                default:
                    System.out.println("Invalid input: " + answer2);
                    return this.equipmentManager();
            }
        } catch (InventoryFullException e) {
            this.menu.exceptionMenu(e);
            return this.equipmentManager();
        }
        
    }
    private void playerSearchesRoom(Player player, Room room) throws PlayerIsDeadException {
        try {
            String answer = this.menu.searchRoomMenu(player, room);
        switch (answer) {
            case "B":
                this.playerTakesTurn(this.player);
                break;
            default :
                int index = Integer.parseInt(answer);
                if (index < room.getItems().length) {
                    player.addItem(room.getItems()[index]);
                    room.removeItem(room.getItems()[index]);
                } else {
                    this.menu.noSuchItemMenu();
                    this.playerSearchesRoom(player, room);
                }
        }
        }catch (InventoryFullException e) {
            this.menu.exceptionMenu(e);
            this.playerSearchesRoom(player, room);
        }
    }
    private void caracterFight(Player player) throws PlayerIsDeadException {
        Room room = this.board.getDungeon()[player.getPosition()];
        if (room.getNPC().length == 0) {
            this.menu.noOneToFightMenu();
            this.playerTakesTurn(this.player);
            return;
        }
        String answer = this.menu.fightMenu(player, this.board.getDungeon()[player.getPosition()]);
        switch (answer){
            case "B":
                this.playerTakesTurn(this.player);
                break;
            default :
                int index = Integer.parseInt(answer);
                if (index < room.getNPC().length) {
                    NPC npc = room.getNPC()[index];
                    Map fightOuput = player.attack(npc, this.board);
                    this.menu.fightResultMenu(fightOuput);
                    if (npc.getStats().getLifePoints() <= 0) {
                        this.menu.dieMenu(npc);
                        npc.die(this.board.getDungeon()[player.getPosition()], player);
                    }
                } else {
                    this.menu.noSuchEnemy();
                    this.caracterFight(player);
                }
        }

    }
    public void playerMoves(Player player) throws PlayerIsDeadException {
        String answer = this.menu.moveMenu(player, this);
            switch (answer) {
                case "N":
                    int role = this.rollDice();
                    this.board.generateRoomContent(player, role);
                    player.move("forward", this.board.getDice().rollDie());
                    break;
                case "P":
                    player.move("backward", this.board.getDice().rollDie());
                    break;
                case "B":
                    this.playerTakesTurn(this.player);
                    break;
                default:
                    System.out.println("Invalid input: " + answer);
                    this.menu.moveMenu(player, this);
            }
    }
    public void playerEntersRoom(Player player, Room room) {
        this.menu.enterRoomMenu(room);
    }

    public int rollDice(){
        int result = this.dice.rollDie();
        return result;
    }
}