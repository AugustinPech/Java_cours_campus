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
    public NPC[] nPCs = new NPC[0];
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
            this.menu.joinedGame((Player) caracter);
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
                default:
                    throw new IllegalArgumentException("Invalid input: " + className);
        }
        } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return this.createCaracter(answerFromMenu);
        }
    }
    public static int roleDice(int [] dice){
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            result+= (int) (Math.random()*dice[i]+1);
        }
        return result;
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
    public void addNPC(NPC NPC){
        NPC[] newNPCs = new NPC[this.nPCs.length+1];
        for (int i = 0; i < this.nPCs.length; i++) {
            newNPCs[i] = this.nPCs[i];
        }
        newNPCs[this.nPCs.length] = NPC;
        this.nPCs = newNPCs;
    }
    public void addPlayer(Player player){
        Player[] newPlayers = new Player[this.players.length+1];
        for (int i = 0; i < this.players.length; i++) {
            newPlayers[i] = this.players[i];
        }
        newPlayers[this.players.length] = player;
        this.players = newPlayers;
    }

    public void startGame() {
        int totalLife = 0;
        for (int i = 0; i < this.players.length; i++) {
            totalLife += this.players[i].lifePoints;
        }
        boolean everyBodyIsDead= (totalLife == 0);
        while (!everyBodyIsDead) {
            for (int i = 0; i < this.players.length; i++) {
                if (this.players[i]!=null){
                    this.playerTakesTurn(this.players[i]);
                }
            }
            for (int i = 0; i < this.nPCs.length; i++) {
                if (this.nPCs[i]!=null){
                    this.playerTakesTurn(this.players[i]);
                }
            }
            everyBodyIsDead = true;
            for (int i = 0; i < this.players.length; i++) {
                if (this.players[i]!=null){
                    everyBodyIsDead = false;
                }
            }
        }
    }
    private void playerTakesTurn(Player player) {
        this.menu.upKeepMenu(player, this);
    }
    public void playerMoves(Player player){
        int oldPosition = player.position;
        String answer = this.menu.moveMenu(player, this);
        switch (answer) {
            case "A":
                player.move("forward");
                break;
            case "Z":
                player.move("Backward");
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
    }
}
