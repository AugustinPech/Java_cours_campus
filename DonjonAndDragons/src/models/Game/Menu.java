package DonjonAndDragons.src.models.Game;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.views.Ascii;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public Scanner scanner;

    public Menu(Game game, User user) {
        this.scanner = new Scanner(System.in);
    }

    public String startMenu(Game game, User user){
        String[] ascii = (Ascii.printTitle());
        for (String line : ascii) {
            System.out.println(line);
        }
        String answer = this.wantToPlay(game, user);
        return answer;
    }
    public String regexCheck (String regex, String answer) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            return "Invalid input: " + answer;
        }
        return answer;
    }
    public String wantToPlay(Game game, User user){
        System.out.println("Do you want to join the adventure? (Y / n)");
        String answer = regexCheck("^[yn]{1}$",this.wantToPlay(game, user));
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return wantToPlay(game, user);
        }
        return answer;
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
        System.out.println(
            "Choose your class by typing : \n"+
            "(1) for Warrior\n"+
            "(2) for Wizard"
        );
        String className = regexCheck("^[12]{1}$",this.scanner.nextLine().toUpperCase());
        if (className.contains("Invalid")) {
            System.out.println(className);
            return joiningGameMenu(user, game);
        }
        System.out.println("Choose the name of your character");
        String charName = this.scanner.nextLine();

        return new String[]{className, charName};
    }
    public void joinedGame(Player player){
        System.out.println(
                    "___________________________________________________________________________________________\n"+
                    "As you step into the world of adventure, a sense of anticipation fills the air. The sound \n"+
                    "of rustling leaves and distant whispers of ancient magic greet your ears. Suddenly, a \n"+
                    "voice calls out from the depths of the forest:\n"+
                    "\"Welcome, " + player.fullName + ", to a realm of endless possibilities and untold dangers!\n"+
                    "Your journey begins now.\""+
                    "___________________________________________________________________________________________\n"
                    );
        this.spriteAndStatsShow(player);
    }
    public void spriteAndStatsShow(Player player) {
        String[] ascii = (Ascii.caracterSpriteAndStats(player));
        for (String line : ascii) {
            System.out.println(line);
        }
    }

    public String moveMenu(Player player, Game game) {
        String answer="";
        if (player.position == 0) {
            System.out.println( "Where do you want to go?\n"+
                        "   (N) Got to next room : "+game.board.dungeon[player.position+1].name+"\n"+
                        "\n"+
                        "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[AE]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        } else if (player.position == game.board.dungeon.length-1) {
            System.out.println( "Where do you want to go?\n"+
                        "\n"+
                        "   (P) Got to previous room: "+game.board.dungeon[player.position+1].name+"\n"+
                        "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[ZE]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        } else {
            System.out.println( "Where do you want to go?\n"+
                    "   (N) Got to next room : "+game.board.dungeon[player.position-1].name+"\n"+
                    "   (P) Got to previous room: "+game.board.dungeon[player.position+1].name+"\n"+
                    "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[NPB]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        }
        return answer;
    }
    public void upKeepMenu(Player player, Game game) {
        int position = player.position;
        Room room = game.board.dungeon[position];
        if (player.position !=0) {
            System.out.println(
                "___________________________________________________________________________________________\n"+
                this.displayBoard(game)+"\n"+
                "______________________________________BOARD________________________________________________\n"
            );
        }
        if (room.ascii!=null){
            String[] ascii = (room.ascii);
            for (String line : ascii) {
                System.out.println(line);
            }
        }
        System.out.println(
            "___________________________________________________________________________________________\n"+
            game.board.dungeon[player.position].great()+"\n"+
            "________________________________________ROOM_GREAT_MSG_____________________________________\n"
        );
    }
    private String displayBoard(Game game) {
        String str = "|";
        for (int i = 0 ; i < game.board.size; i++) {
            Room room = game.board.dungeon[i];
            str +="|";
            if (i == game.player.position) {
                str += " "+ game.player.sprite ;
            } else {
                str += "";
            }
            str +=" "+ room.toString() + "|";
        }
            str +="|";
        return str;
    }
    public String doorStepMenu(Player player, Game game) {
        System.out.println(
            "What do you wish to do? \n" +
            "   (K) Knock the door like an idiot\n"+
            "   (W) Go back home like a coward\n"+
            "   (I) Go in like a noob\n"
        );
        String answer = regexCheck("^[KWI]{1}$",this.scanner.nextLine().toUpperCase());
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return doorStepMenu(player, game);
        }
        return answer;
    }
    public String beginningOfTurnMenu(Player player, Game game) {
        String answer = "";
        if (player.position == 0){
            answer = this.doorStepMenu(player, game);
        } else {
            System.out.println( 
                "What do you wish to do? \n" +
                "   (M) Move\n"+
                "   (A) Attack\n"+
                "   (U) Use item\n"+
                "   (S) Skip turn\n"+
                "   (W) Withdraw from the dungeon");
            answer = regexCheck("^[MAUSW]{1}$",this.scanner.nextLine().toUpperCase());
            System.out.println(answer + "    " + player.position);
        }
        return answer;
    }

    public void youDiedMenu(Game game, Caracter caracter) {
        String[] ascii = (Ascii.youDied());
        for (String line : ascii) {
            System.out.println(line);
        }
    }

    public String gameOverMenu(Game game, User user) {
        String answer = "";
        String[] ascii = (Ascii.gameOver());
        for (String line : ascii) {
            System.out.println(line);
        }
        answer = regexCheck("^[yn]{1}$",this.wantToPlay(game, user));
        return answer;
    }
}
