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
        String[] ascii = (Ascii.printTitle());
        for (String line : ascii) {
            System.out.println(line);
        }
        this.wantToPlay(game, user);
    }
    public String checkAnswer (String regex, String answer) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            return "Invalid input: " + answer;
        }
        return answer;
    }
    public void wantToPlay(Game game, User user){
        System.out.println("Do you want to join the adventure? (Y / n)");
        String answer = this.scanner.nextLine().toLowerCase();
        switch (answer) {
            case "n": 
                this.leaveGameMenu();
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
    public boolean leaveGameMenu() {
        String[] ascii = (Ascii.NegateLetter());
        for (String line : ascii) {
            System.out.println(line);
        } 
        boolean playerLeavesGame = true;
        return playerLeavesGame; 
    }

    public String[] joiningGameMenu(User user, Game game){
        try {
        Scanner input = this.scanner;
        System.out.println(
            "Choose your class by typing : \n"+
            "(A) for Warrior\n"+
            "(Z) for Wizard"
        );
        String className = input.nextLine().toUpperCase();
        Pattern pattern = Pattern.compile("^[azAZ]{1}$");
        Matcher matcher = pattern.matcher(className);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            System.out.println("Invalid input: " + className);
            return joiningGameMenu(user, game);
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
        String[] ascii = (Ascii.caracterSpriteAndStats(player));
        for (String line : ascii) {
            System.out.println(line);
        }
    }

    public String moveMenu(Player player, Game game) {
        if (player.position == 0) {
            System.out.println( "Where do you want to go?\n"+
                            "   (A) Got to next room : "+game.board.dungeon[player.position+1].name+"\n"+
                            "\n"+
                            "   (E) You changed your mind. (go to previous menu)");
        } else if (player.position == game.board.dungeon.length-1) {
            System.out.println( "Where do you want to go?\n"+
                            "\n"+
                            "   (Z) Got to previous room: "+game.board.dungeon[player.position+1].name+"\n"+
                            "   (E) You changed your mind. (go to previous menu)");
        } else {
                    System.out.println( "Where do you want to go?\n"+
                            "   (A) Got to next room : "+game.board.dungeon[player.position-1].name+"\n"+
                            "   (Z) Got to previous room: "+game.board.dungeon[player.position+1].name+"\n"+
                            "   (E) You changed your mind. (go to previous menu)");
        }
        String answer = this.scanner.nextLine().toUpperCase();
        return answer;
    }
    public void youDiedMenu(Game game, Caracter caracter) {
        String[] ascii = (Ascii.youDied());
        for (String line : ascii) {
            System.out.println(line);
        }
    }
    public String upKeepMenu(Player player, Game game) {
        int position = player.position;
        Room room = game.board.dungeon[position];
        String listNPCinRoom = room.encounter(player, game);
        String str= "";

        if (position == 0) {
            String[] ascii = (Ascii.doorStep());
            System.out.println(
                    "___________________________________________________________________________________________\n"+
                    this.displayBoard(game)+"\n"+
                    "________________________________________ROOM_GREAT_MSG_____________________________________\n"
                );
            for (String line : ascii) {
                System.out.println(line);
            }
            str = this.doorStepMenu(player, game);

        } else if (position == game.board.dungeon.length-1) {
            System.out.println(
                "You are in the last room"
                        );
            
        } else {
                System.out.println(
                    "___________________________________________________________________________________________\n"+
                    game.board.dungeon[player.position].great()+"\n"+
                    "________________________________________ROOM_GREAT_MSG_____________________________________\n"
                );
                str = this.beginningOfTurnMenu(player, game);
        }

        return str;
    }

    private String displayBoard(Game game) {
        String str = "|";
        for (Room room : game.board.dungeon) {
            str +="|"+ room.npcSprites() + "|";
        }
        return str;
    }

    public String doorStepMenu(Player player, Game game) {
        System.out.println(
            game.board.dungeon[player.position].great()+"\n"+
            "What do you wish to do? \n" +
            "   (A) Knock the door like an idiot\n"+
            "   (W) Go back home like a coward\n"+
            "   (E) Go in like a noob\n"
        );
        String answer = this.scanner.nextLine().toUpperCase();
        return answer;

    }

    public String beginningOfTurnMenu(Player player, Game game) {
        System.out.println( 
                            "What do you wish to do? \n" +
                            "   (R) Move\n"+
                            "   (T) Attack\n"+
                            "   (Y) Use item\n"+
                            "   (U) Skip turn\n"+
                            "   (W) Withdraw from the dungeon");
        String answer = this.scanner.nextLine().toUpperCase();
        System.out.println(answer + "    " + player.position);
        return answer;

    }

    public void knockMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'knockMenu'");
    }
}
