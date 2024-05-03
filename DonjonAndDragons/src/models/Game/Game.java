package DonjonAndDragons.src.models.Game;

import java.util.Map;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Caracters.Player.Warrior;
import DonjonAndDragons.src.models.Caracters.Player.Wizard;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons.src.models.Game.Exception.NotUseAbleException;
import DonjonAndDragons.src.models.items.Item;

public class Game {
    public Player player;
    public Board board;
    public Menu menu;


    /**
     * Constructs a new Game object.
     * 
     * @param user the User object representing the player of the game
     */
    public Game(User user) {
        this.menu = new Menu();
        this.board = new Board(10, this);
        this.board.setDungeon(this);
        String answer = this.menu.startMenu(this, user);
        this.userBecomesPlayer(user, answer);
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
                this.menu.wantToPlay( this, user);
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
    public void caracterDies(Caracter caracter){
        this.player=null;
        caracter.die(this); 
        this.menu.youDiedMenu(this, caracter);       
    }
    public void startGame(User user) {
        int totalLife = this.player.getStats().getLifePoints();
        boolean everyBodyIsDead= (totalLife <= 0);
        boolean playerStillPlaying = true;
        boolean win = false;
        boolean playing = !everyBodyIsDead && playerStillPlaying || !win;

        while (playing) {
            this.menu.upKeepMenu(player, this);

            String str = this.playerTakesTurn(this.player);
            playerStillPlaying = (str == "stillPlaying");
            
            this.npcTakesTurn(this.player);
            totalLife = this.player.getStats().getLifePoints();
            everyBodyIsDead = (totalLife <= 0);
            win = this.isWin();
            
            playing = !everyBodyIsDead && !playerStillPlaying ||  !win;

        }

        if (everyBodyIsDead) {
            String answer=this.menu.gameOverMenu(this, user);
            userBecomesPlayer(user, answer);
        }
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
    private String playerTakesTurn(Player player) {
        int oldPosition = player.getPosition();

        String playerStillPlaying = "stillPlaying";
        

        String answer=this.menu.beginningOfTurnMenu(player);
            switch (answer) {
                case "K":
                    player.move("forward");
                    break;
                case "W":
                    playerStillPlaying = this.menu.leaveGameMenu();
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
                    playerStillPlaying = this.menu.skipTurnMenu(player);
                    break;
                case "C":
                    this.menu.spriteAndStatsShow(player);
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
        return playerStillPlaying;
    }
    private boolean isWin() {
        for (Room room : this.board.getDungeon()) {
            if (room.getNPC() != null) {
                return false;
            }
        }
        System.out.println("You have defeated all the enemies and won the game!");
        return true;
    }
    private void inventoryManager() {
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
                    Item [] resultOfUse = this.player.useItem(Integer.valueOf(answer), "inventory");
                    if (resultOfUse.length != 0) {
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
        }
    }
    private void equipmentManager() {
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
                case "D":
                    Item [] resultOfUse = this.player.useItem(Integer.valueOf(answer), "equipment");
                    if (resultOfUse.length != 0) {
                        for (Item item : resultOfUse) {
                            this.board.getDungeon()[this.player.getPosition()].addItem(item);
                        }
                    }
                case "U":
                    this.player.unEquip(Integer.valueOf(answer), this.board.getDungeon()[this.player.getPosition()]);
                    break;
                default:
                    System.out.println("Invalid input: " + answer2);
                    this.menu.equipmentMenu(this.player);
            }
        }  catch (NotUseAbleException e) {
            this.menu.exceptionMenu(e);
            this.equipmentManager();
        }
        
    }
    private void playerSearchesRoom(Player player, Room room) {
        String answer = this.menu.searchRoomMenu(player, room);
        switch (answer) {
            case "B":
                this.playerTakesTurn(this.player);
                break;
            default :
                int index = Integer.parseInt(answer);
                player.addItem(room.getItems()[index]);
                room.removeItem(room.getItems()[index]);
        }
    }
    private void caracterFight(Player player) {
        String answer = this.menu.fightMenu(player, this);
        switch (answer){
            case "B":
                this.playerTakesTurn(this.player);
                break;
            default :
                int index = Integer.parseInt(answer);
                NPC npc = this.board.getDungeon()[player.getPosition()].getNPC()[index];
                Map fightOuput = player.attack(npc, this.board);
                this.menu.fightResultMenu(fightOuput);
                if (npc.getStats().getLifePoints() <= 0) {
                    this.menu.dieMenu(npc);
                    npc.die(this);
                }
        }

    }
    public void playerMoves(Player player){
        String answer = this.menu.moveMenu(player, this);
        switch (answer) {
            case "N":
                int[] dice = {100};
                int role = this.roleDice(dice);
                this.board.generateRoomContent(this, role);
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

    public int roleDice(int [] dice){
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            result+= (int) (Math.random()*dice[i]+1);
        }
        return result;
    }
}