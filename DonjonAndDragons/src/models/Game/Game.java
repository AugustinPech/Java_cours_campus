package DonjonAndDragons.src.models.Game;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC;
import DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Caracters.Warrior;
import DonjonAndDragons.src.models.Caracters.Wizard;

public class Game {
        public int indexOf(Caracter[] array, Caracter caracter){
            for (int i = 0; i < array.length; i++) {
                if (array[i] == caracter){
                    return i;
                }
            }
            return -1;
        };
    public Player[] players= new Player[0];
    public Board board;
    public Menu menu;
    

    public Game(User user) {
        this.menu = new Menu(this, user);
        this.board = new Board(10, this);
        this.menu.startMenu(this, user);
    }

    public void userJoinsGame(User user) {
            String[] answer = this.menu.joiningGameMenu(user, this);
            Caracter caracter = this.createCaracter(answer);
            this.addPlayer((Player) caracter);
            for (Player player : this.players){
                this.menu.joinedGame(player);
            }
    }
    public Caracter createCaracter(String[] answerFromMenu) {
        try {
            String className = answerFromMenu[0];
            String charName = answerFromMenu[1];
            switch (className){
                case "A":
                    return new Warrior(charName, this);
                case "Z":
                    return new Wizard(charName,  this);
                case "NPC":
                    return new NPC(charName, this);
                default:
                    throw new IllegalArgumentException("Invalid input: " + className);
        }
        } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return this.createCaracter(answerFromMenu);
        }
    }
    public void addPlayer(Player player){
        Player[] newPlayers = new Player[this.players.length+1];
        for (int i = 0; i < this.players.length; i++) {
            newPlayers[i] = this.players[i];
        }
        newPlayers[this.players.length] = player;
        this.players = newPlayers;
    }
    public void caracterDies(Caracter caracter){
        int index = this.indexOf(this.players, caracter);
        this.players[index]=null;
        Player[] newPlayers = new Player[this.players.length-1];
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i]!=null){
                newPlayers[i] = this.players[i];
            }
        }
        this.players = newPlayers;
        caracter.die(this.board.dungeon[caracter.position]); 
        this.menu.youDiedMenu(this, caracter);       
    }
    public void startGame() {
        int totalLife = 0;
        for (int i = 0; i < this.players.length; i++) {
            totalLife += this.players[i].lifePoints;
        }
        boolean everyBodyIsDead= (totalLife <= 0);
        boolean playerLeavesGame = false;
        boolean playing = !everyBodyIsDead && !playerLeavesGame;
        while (playing) {
            for (int i = 0; i < this.players.length; i++) {
                if (this.players[i]!=null){
                    playerLeavesGame = this.playerTakesTurn(this.players[i]);
                }
            }
            everyBodyIsDead = true;
            for (int i = 0; i < this.players.length; i++) {
                if (this.players[i]!=null){
                    everyBodyIsDead = false;
                }
            }
            playing = !everyBodyIsDead && !playerLeavesGame;
        }
    }
    private boolean playerTakesTurn(Player player) {
        boolean playerLeavesGame = false;
        String answer=this.menu.upKeepMenu(player, this);
            switch (answer) {
                case "A":
                    this.menu.knockMenu();
                    break;
                case "W":
                    playerLeavesGame = this.menu.leaveGameMenu();
                    break;
                case "E":
                    player.move("forward");
                    break;
                case "R":
                    this.playerMoves(player);
                    break;
                case "T":
                    //game.playerAttacks(player);
                    break;
                case "Y":
                    //game.playerUseItem(player);
                    break;
                case "U":
                    //this.skipTurnMenu(player);
                    break;
                default:
                    System.out.println("Invalid input: " + answer);
                    this.menu.upKeepMenu(player, this);
            }
        return playerLeavesGame;
    }
    public void playerMoves(Player player){
        int oldPosition = player.position;
        String answer = this.menu.moveMenu(player, this);
        switch (answer) {
            case "A":
                player.move("forward");
                break;
            case "Z":
                player.move("backward");
                break;
            case "E":
                this.menu.upKeepMenu(player, this);
                break;
            default:
                System.out.println("Invalid input: " + answer);
                this.menu.moveMenu(player, this);
        }
        if (player.position != oldPosition){
            this.playerEntersRoom(player, this.board.dungeon[player.position]);
        }
    }
    public void playerEntersRoom(Player player, Room room) {
        room.encounter(player, this);
        System.out.println(player.position); //debug
    }
    public static int roleDice(int [] dice){
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            result+= (int) (Math.random()*dice[i]+1);
        }
        return result;
    }
}
