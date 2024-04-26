package DonjonAndDragons.src.models.Game;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.views.Ascii;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public Scanner scanner;

    public Menu(Game game, User user) {
        this.scanner = new Scanner(System.in);
    }

    public void startMenu(Game game, User user){
        System.out.println(Ascii.printTitle());
        this.wantToPlay(game, user);
    }

    public void wantToPlay(Game game, User user){
        System.out.println("Do you want to join the adventure? (Y / n)");
        String answer = this.scanner.nextLine().toLowerCase();
        switch (answer) {
            case "n":      
                System.out.println(Ascii.NegateLetter());
                break;
            case "y":
                game.userJoinsGame(user);
                break;
            case "":
                game.userJoinsGame(user);
                break;
            default:
                System.out.println("Invalid input: " + answer);
                this.wantToPlay( game, user);
        } 
    }
    public String[] joiningGameMenu(User user, Game game){
        try {
        Scanner input = this.scanner;
        System.out.println("Choose your class by typing : \n (A) for Warrior\n (Z) for Wizard");
        String className = input.nextLine().toUpperCase();
        Pattern pattern = Pattern.compile("^[azAZ]{1}$");
        Matcher matcher = pattern.matcher(className);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new IllegalArgumentException("Invalid input: " + className);
        }
        System.out.println("Choose the name of your character");
        String charName = input.nextLine();
        return new String[]{className, charName};
        } catch (IllegalArgumentException e) {
            System.out.println( "Invalid input" + e.getMessage());
            return joiningGameMenu(user, game);
        }
    }
    public void joinedGame(Player player){
        System.out.println("Welcome " + player.fullName + "!");
        this.spriteAndStatsShow(player);
    }
    public void spriteAndStatsShow(Player player) {
        System.out.println(Ascii.playerSpriteAndStats(player));
    }

    public void upKeepMenu(Player player, Game game) {
        System.out.println("What do you want to do?");
        System.out.println("A. Move");
        System.out.println("Z. Attack");
        System.out.println("E. Use item");
        System.out.println("R. Skip turn");
        System.out.println("T. Withdraw from the dungeon");
        String answer = this.scanner.nextLine().toUpperCase();
        switch (answer) {
            case "A":
                this.moveMenu(player, game);
                break;
            case "Z":
                //this.attackMenu(player);
                break;
            case "E":
                //this.useItemMenu(player);
                break;
            case "R":
                //this.skipTurnMenu(player);
                break;
            case "T":
                //this.withdrawMenu(player);
                break;
            default:
                System.out.println("Invalid input: " + answer);
                this.upKeepMenu(player, game);
        }
    }

    public void moveMenu(Player player, Game game) {
        System.out.println("Where do you want to go?");
        System.out.println("(A) Next room");
        System.out.println("(Z) Previous room");
        System.out.println("(E) You changed your mind. (go to previous menu)");
        String answer = this.scanner.nextLine().toUpperCase();
        switch (answer) {
            case "A":
                game.playerMoves(player, "forward");
                break;
            case "Z":
                game.playerMoves(player,"Backward");
                break;
            case "E":
                this.upKeepMenu(player, game);
                break;
            default:
                System.out.println("Invalid input: " + answer);
                this.moveMenu(player, game);
        }
    }
    public void youDiedMenu(Game game, Caracter caracter) {
        System.out.println(Ascii.youDied());
    }
}
