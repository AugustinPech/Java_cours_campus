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
import DonjonAndDragons.src.models.items.Item;

public class Game {
    public Player player;
    public Board board;
    public Menu menu;
    private int turnNumber;
    private User user;
    /**
     * Constructs a new Game object.
     * 
     * @param user the User object representing the player of the game
     */
    public Game(User user) {
        this.user = user;
        this.menu = new Menu();
        String answer = this.menu.startMenu(user);
        String difficulty = this.menu.chooseDifficultyMenu();
        this.userBecomesPlayer(user, answer);
        switch (difficulty) {
            case "1" :
                this.board = new Board(10);
                this.board.setDungeon();
                break;
            case "2" :
                this.board = new Board(10);
                this.board.setDungeon();
                break;
            case "3" :
                this.board = new Board(10);
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
                    player.move("forward");
                    break;
                case "W":
                    playerChoice = this.menu.leaveGameMenu();
                    break;
                case "I":
                    this.board.nPCAreOstile();
                    player.move("forward");
                    break;
                case "M":
                    this.playerMoves(player);
                    break;
                case "A":
                    this.caracterFight(player);
                    break;
                case "U":
                    this.inventoryManager();
                    break;
                case "S":
                    playerChoice = this.menu.skipTurnMenu(player);
                    break;
                case "C":
                    this.menu.spriteAndStatsShow(player);
                    this.playerTakesTurn(player);
                    break;
                case "L":
                    this.playerSearchesRoom(player, this.board.getDungeon()[player.getPosition()]);
                    break;
                case "E":
                    this.equipmentManager();
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
    private void inventoryManager() throws PlayerIsDeadException {
        try{
            String answer = this.menu.inventoryMenu(this.player);
            String answer2= "";

            switch (answer) {
                case "B":
                    this.playerTakesTurn(this.player);
                    break;
                case "E":
                    this.equipmentManager();
                    break;
                default:
                    answer2 = this.menu.itemInIventoryMenu(this.player, Integer.valueOf(answer));
            }
            switch (answer2) {
                case "B":
                    this.menu.inventoryMenu(this.player);
                    break;
                case "D":
                    this.player.dropItem(Integer.valueOf(answer), this.board.getDungeon()[this.player.getPosition()]);
                    break;
                case "E":
                    this.player.equipItem(Integer.valueOf(answer));
                    break;
                case "U":
                    Item [] resultOfUse = this.player.useItem(Integer.valueOf(answer));
                    if (resultOfUse != null) {
                        for (Item item : resultOfUse) {
                            this.board.getDungeon()[this.player.getPosition()].addItem(item);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input: " + answer2);
                    this.menu.inventoryMenu(this.player);
            }
        } catch (NotEquipableException e) {
            this.menu.exceptionMenu(e);
            this.inventoryManager();
        } catch (NotUseAbleException e) {
            this.menu.exceptionMenu(e);
            this.inventoryManager();
        } catch (EquipmentFullException e) {
            this.menu.exceptionMenu(e);
            this.equipmentManager();
        }
    }
    private void equipmentManager()  throws PlayerIsDeadException {
        try{
            String answer = this.menu.equipmentMenu(this.player);
            String answer2= "";

            switch (answer) {
                case "B":
                    this.menu.inventoryMenu(this.player);
                    break;
                case "I" :
                    this.inventoryManager();
                    break;
                default:
                    answer2 = this.menu.itemInEquipmentMenu(this.player, Integer.valueOf(answer));
            }
            switch (answer2) {
                case "B":
                    this.menu.equipmentMenu(this.player);
                    break;
                case "U":
                    this.player.unEquip(Integer.valueOf(answer), this.board.getDungeon()[this.player.getPosition()]);
                    break;
                default:
                    System.out.println("Invalid input: " + answer2);
                    this.menu.equipmentMenu(this.player);
            }
        } catch (InventoryFullException e) {
            this.menu.exceptionMenu(e);
            this.equipmentManager();
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
                int[] dice = {100};
                int role = this.rollDice(dice);

                this.board.generateRoomContent(player, role);
                player.move("forward");
                break;
            case "P":
                player.move("backward");
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

    public int rollDice(int [] dice){
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            result+= (int) (Math.random()*dice[i]+1);
        }
        return result;
    }
}