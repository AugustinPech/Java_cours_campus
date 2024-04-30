package DonjonAndDragons.src.models.Game;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Caracters.Player.Warrior;
import DonjonAndDragons.src.models.Caracters.Player.Wizard;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Board.Room;

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
        this.menu = new Menu(this, user);
        this.board = new Board(30, this);
        String answer = this.menu.startMenu(this, user);
        this.userBePlayer(user, answer);
    }
    public void userBePlayer(User user, String answer){
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
     * Represents a character in the game.
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
                default:
                    throw new IllegalArgumentException("Invalid input: " + className);
        }
        } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return this.createCaracter(answerFromMenu);
        }
    }
    public void addPlayer(Player player){

        this.player = player;
    }
    public void caracterDies(Caracter caracter){
        
        this.player=null;
        caracter.die(this.board.dungeon[caracter.position]); 
        this.menu.youDiedMenu(this, caracter);       
    }
    public void startGame(User user) {
        int totalLife = this.player.lifePoints;
        boolean everyBodyIsDead= (totalLife <= 0);
        boolean playerLeavesGame = false;
        boolean playing = !everyBodyIsDead && !playerLeavesGame;

        while (playing) {
            playerLeavesGame = this.playerTakesTurn(this.player);
            everyBodyIsDead = (totalLife <= 0);
            playing = !everyBodyIsDead && !playerLeavesGame;
        }

        if (everyBodyIsDead) {
            String answer=this.menu.gameOverMenu(this, user);
            userBePlayer(user, answer);
        }
    }
    private boolean playerTakesTurn(Player player) {
        int oldPosition = player.position;

        boolean playerLeavesGame = false;
        
        this.menu.upKeepMenu(player, this);

        String answer=this.menu.beginningOfTurnMenu(player, this);
            switch (answer) {
                case "K":
                    player.move("forward");
                    break;
                case "W":
                    playerLeavesGame = this.menu.leaveGameMenu();
                    break;
                case "I":
                    this.board.nPCAreOstile();
                    player.move("forward");
                    break;
                case "M":
                    this.playerMoves(player);
                    break;
                case "A":
                    //game.playerAttacks(player);
                    break;
                case "U":
                    //game.playerUseItem(player);
                    break;
                case "S":
                    //this.skipTurnMenu(player);
                    break;
                default:
                    System.out.println("Invalid input: " + answer);
                    this.menu.upKeepMenu(player, this);
            }
        if (player.position != oldPosition){
            this.playerEntersRoom(player, this.board.dungeon[player.position]);
        }
        return playerLeavesGame;
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
                this.menu.beginningOfTurnMenu(player, this);
                break;
            default:
                System.out.println("Invalid input: " + answer);
                this.menu.moveMenu(player, this);
        }
    }
    public void playerEntersRoom(Player player, Room room) {
    }

    public int roleDice(int [] dice){
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            result+= (int) (Math.random()*dice[i]+1);
        }
        return result;
    }
}
