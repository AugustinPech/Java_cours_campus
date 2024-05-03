package DonjonAndDragons.src.models.Game;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.Game.Exception.NotUseAbleException;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.views.Ascii;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public String startMenu(Game game, User user){
        String[] ascii = (Ascii.printTitle());
        for (String line : ascii) {
            System.out.println(line);
        }
        String answer = this.wantToPlay(game);
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
    public String wantToPlay(Game game){
        System.out.println("Do you want to join the adventure? (Y / n)");
        String answer = regexCheck("^[yn]{0,1}$",this.scanner.nextLine().toLowerCase()); // fix regex
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return wantToPlay(game);
        }
        return answer;
    }
    public String leaveGameMenu() {
        String[] ascii = (Ascii.NegateLetter());
        for (String line : ascii) {
            System.out.println(line);
        } 
        String playerLeavesGame = "leavesGame";
        return playerLeavesGame; 
    }

    public String[] joiningGameMenu(User user, Game game){
        System.out.println(
            "Choose your class by typing : \n"+
            "(1) for Warrior\n"+
            "(2) for Wizard"
        );
        String className = regexCheck("^[123]{1}$",this.scanner.nextLine().toUpperCase());
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
                    "\"Welcome, " + player.getFullName() + ", to a realm of endless possibilities and untold dangers!\n"+
                    "Your journey begins now.\"\n"+
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

    public void upKeepMenu(Player player, Game game) {
        if (player.getPosition() !=0) {
            System.out.println(
                "___________________________________________________________________________________________\n"+
                this.displayBoard(game)+"\n"+
                "______________________________________BOARD________________________________________________\n"
            );
        }
    }

    private String displayBoard(Game game) {
        String str = "|";
        for (int i = 0 ; i < game.board.getSize(); i++) {
            Room room = game.board.getDungeon()[i];
            str +="|";
            if (i == game.player.getPosition()) {
                str += " "+ game.player.getSprite() ;
            } else {
                str += "";
            }
            str +=" "+ room.toString() + "|";
        }
            str +="|";
        return str;
    }
    public String doorStepMenu(Player player) {
        System.out.println(
            "What do you wish to do? \n" +
            "   (K) Knock the door like an idiot\n"+
            "   (W) Go back home like a coward\n"+
            "   (I) Go in like a noob\n"
        );
        String answer = regexCheck("^[KWI]{1}$",this.scanner.nextLine().toUpperCase());
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return doorStepMenu(player);
        }
        return answer;
    }

    public String beginningOfTurnMenu(Player player) {
        String answer = "";
        if (player.getPosition() == 0){
            answer = this.doorStepMenu(player);
        } else {
            System.out.println( 
                "What do you wish to do? \n" +
                "   (M) Move\n"+
                "   (A) Attack\n"+
                "   (U) Inventory\n"+
                "   (E) Equipment\n"+
                "   (L) Search the room\n"+
                "   (S) Skip turn\n"+
                "   (C) See stats\n"+
                "   (W) Withdraw from the dungeon\n"
            );
            answer = regexCheck("^[MAUESLWC]{1}$",this.scanner.nextLine().toUpperCase());
        }
        return answer;
    }

    public void youDiedMenu(Game game, Caracter caracter) {
        String[] ascii = (Ascii.youDied());
        for (String line : ascii) {
            System.out.println(line);
        }
    }

    public String gameOverMenu(Game game) {
        String answer = "";
        String[] ascii = (Ascii.gameOver());
        for (String line : ascii) {
            System.out.println(line);
        }
        answer = this.wantToPlay(game);
        return answer;
    }

    public String fightMenu(Player player, Game game) {
        String answer = "";
        String[] ascii = (Ascii.fight());
        for (String line : ascii) {
            System.out.println(line);
        }
        String str = 
            "You are in"+game.board.getDungeon()[player.getPosition()]+"\n"+
            "You can attack eather of these targets : \n";
        int index = 0;
        for (Caracter caracter : game.board.getDungeon()[player.getPosition()].getNPC()) {
            str += "   ("+index+")"+caracter.getFullName()+"\n";
            index ++;
        }
        str += "   (B) You changed your mind. (go to previous menu)";
        System.out.println(str);
        answer = regexCheck("^[0-9B]{1}$",this.scanner.nextLine().toUpperCase());
        if (answer.contains("Invalid")) {
                System.out.println(answer);
                return fightMenu(player, game);
        }
        return answer;
    }

    public String moveMenu(Player player, Game game) {
        String answer="";
        if (player.getPosition() == 0) {
            System.out.println( "Where do you want to go?\n"+
                        "   (N) Got to next room : "+game.board.getDungeon()[player.getPosition()+1].getName()+"\n"+
                        "\n"+
                        "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[AE]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        } else if (player.getPosition() == game.board.getDungeon().length-1) {
            System.out.println( "Where do you want to go?\n"+
                        "\n"+
                        "   (P) Got to previous room: "+game.board.getDungeon()[player.getPosition()-1].getName()+"\n"+
                        "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[ZE]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        } else {
            System.out.println( "Where do you want to go?\n"+
                    "   (N) Got to next room : "+game.board.getDungeon()[player.getPosition()-1].getName()+"\n"+
                    "   (P) Got to previous room: "+game.board.getDungeon()[player.getPosition()+1].getName()+"\n"+
                    "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[NPB]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        }
        return answer;
    }

    public void dieMenu(NPC npc) {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "You have defeated "+npc.getFullName()+"\n"+
            "His corps is now lying on the ground\n"+
            "___________________________________________________________________________________________\n"
        );
    }

    public String searchRoomMenu(Player player, Room room) {
        String answer ="";
        String str = "You are in "+room.getName()+"\n";
        if (room.getNPC().length > 0) {
            str += "You see the following characters in the room : \n";
            int index = 0;
            for (NPC npc : room.getNPC()) {
                str += "      "+npc.getFullName()+"\n";
                index ++;
            }
            str += " You can not loot a room if it is guarded. \n";
        } else {
            if (room.getItems() != null) {
                    str += "You see the following items in the room : \n";
                    int index = 0;
                for (Item item : room.getItems()) {
                    str += "   ("+index+")"+item.getName()+"\n";
                    index ++;
                }
                str += " Try any number to pick up an item or type : \n";
            }
        }
            str += "   (B) You changed your mind. (go to previous menu)";
        System.out.println(str);
        answer = regexCheck("^[0-9B]{1}$",this.scanner.nextLine().toUpperCase());
        if (answer.contains("Invalid")) {
                System.out.println(answer);
                return searchRoomMenu(player, room);
        }
        return answer;
    }

    public void enterRoomMenu(Room room) {
        if (room.getAscii()!=null){
            String[] ascii = (room.getAscii());
            for (String line : ascii) {
                System.out.println(line);
            }
        }
        System.out.println(
            "___________________________________________________________________________________________\n"+
            room.great()+"\n"+
            "________________________________________ROOM_GREAT_MSG_____________________________________\n"
        );
    }

    public String skipTurnMenu(Player player) {
        String answer = "";
        System.out.println("You choosed to skip your turn. \n Are you certain ? (Y / n)");
        answer = regexCheck("^[yn]{0,1}$",this.scanner.nextLine().toLowerCase());
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return skipTurnMenu( player) ;
        }
        return answer;
    }

    public void fightResultMenu(Map fightOuput) {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            fightOuput.get("attacking caracter") + " attacked " + fightOuput.get("defending caracter") + "\n"+
            " The fight resulted in : \n"+
            "   Resulting damages (raw damage -- armor) : "+fightOuput.get("damage taken")+"("+fightOuput.get("damage inflicted")+"--"+fightOuput.get("armor")+")\n"+
            "   "+fightOuput.get("defending caracter")+" lost "+fightOuput.get("damage taken")+" life points\n"+

            "___________________________________________________________________________________________\n"
        );
    }

    public String inventoryMenu(Player player) {
        String answer = "";

        String str = 
            "___________________________________________________________________________________________\n"+
            "You have the following items in your inventory : \n";
        int index = 0;
        if (player.getInventory().length!=0){
            for (Item item : player.getInventory()) {
                if (item !=null){
                    str += "   ("+index+") "+ item.getMipple()+" "+item.getName()+"\n";
                } else {
                    str += "   ("+index+") "+ "📦 Empty\n";}
                index ++;
            }
        }
        str+= "    Type any of these numbers if you wish to see more about the given Item\n";
        str+= "   (E) Manage your equipment\n";
        str +="   (B) You changed your mind. (go to previous menu)\n"+
            "___________________________________________________________________________________________\n";
        System.out.println(str);
        answer = regexCheck("^[0-9BE]{0,1}$",this.scanner.nextLine().toUpperCase());

        if (answer.contains("Invalid")) {
                System.out.println(answer);
                return inventoryMenu(player);
        }

        return answer;
    }

    public String itemInIventoryMenu(Player player, int index) {
        String answer = "";

        String str = "___________________________________________________________________________________________\n";
        str+= player.getInventory()[index].getStats().toString()+"\n";
        str +=
            "   (E) Equip the item\n"+
            "   (D) Drop the item\n"+
            "   (U) Use the item\n"+
            "   (B) You changed your mind. (go to previous menu)\n"+
            "___________________________________________________________________________________________\n";
        System.out.println(str);
        answer = regexCheck("^[EUDB]{0,1}$",this.scanner.nextLine().toUpperCase());
                if (answer.contains("Invalid")) {
                System.out.println(answer);
                return itemInIventoryMenu( player, index);
        }

        return answer;
    }

    public String equipmentMenu(Player player) {
        String answer = "";

        String str = 
            "___________________________________________________________________________________________\n"+
            "You have the following items in your equipment : \n";
        int index = 0;
        if (player.getEquipment().length!=0){
            for (Item item : player.getEquipment()) {
                if (item !=null){
                    str += "   ("+index+") "+ item.getMipple()+" "+item.getName()+"\n";
                } else {
                    str += "   ("+index+") "+ "📦 Empty\n";}
                index ++;
            }
        }
        str+= "    Type any of these numbers if you wish to see more about the given Item\n";
        str+= "   (I) Manage your inventory\n";
        str +="   (B) You changed your mind. (go to previous menu)\n"+
            "___________________________________________________________________________________________\n";
        System.out.println(str);
        answer = regexCheck("^[0-9BI]{0,1}$",this.scanner.nextLine().toUpperCase());

        if (answer.contains("Invalid")) {
                System.out.println(answer);
                return equipmentMenu(player);
        }
        return answer;
    }

    public String itemInEquipmentMenu(Player player, Integer index) {
        String answer = "";

        String str = "___________________________________________________________________________________________\n";
        str+= player.getEquipment()[index].getStats().toString()+"\n";
        str +=
            "   (D) Use the item\n" + 
            "   (U) Un-equip the item\n"+
            "   (B) You changed your mind. (go to previous menu)\n"+
            "___________________________________________________________________________________________\n";
        System.out.println(str);
        answer = regexCheck("^[UDB]{0,1}$",this.scanner.nextLine().toUpperCase());
                if (answer.contains("Invalid")) {
                System.out.println(answer);
                return itemInIventoryMenu( player, index);
        }

        return answer;
    }

    public void exceptionMenu(Exception e) {
        System.out.println(e.getMessage());
    }
}
//item.getStats().toString()+"\n";