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
    public String chooseDifficultyMenu(){
        System.out.println(
            "Choose the difficulty of the game by typing : \n"+
            "(1) if you are new and want to play the tutorial\n"+
            "(2) if you know the game but don't want to bother with hard stuff\n"+
            "(3) if you are a challenger and want to test your skills\n"
        );
        String answer = regexCheck("^[123]{1}$",this.scanner.nextLine().toUpperCase());
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return chooseDifficultyMenu();
        }
        return answer;

    }
    public String startMenu(User user){
        String[] ascii = (Ascii.printTitle());
        for (String line : ascii) {
            System.out.println(line);
        }
        String answer = this.wantToPlay();
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
    public String wantToPlay(){
        System.out.println("Do you want to join the adventure? (Y / n)");
        String answer = regexCheck("^[yn]{0,1}$",this.scanner.nextLine().toLowerCase());
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return wantToPlay();
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

    public String beginningOfTurnMenu(Player player, int turnNumber) {
        String answer = "";
        if (player.getPosition() == 0){
            answer = this.doorStepMenu(player);
        } else {
            System.out.println( 
                "What do you wish to do?                                turn n°: " + turnNumber+ "\n" +
                "   (M) Move\n"+
                "   (A) Attack\n"+
                "   (U) Inventory\n"+
                "   (E) Equipment\n"+
                "   (L) Search the room\n"+
                "   (C) See stats\n"+
                "   (W) Withdraw from the dungeon\n"+
                "   (ENTER) Skip turn\n"
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

    public String gameOverMenu() {
        String answer = "";
        String[] ascii = (Ascii.gameOver());
        for (String line : ascii) {
            System.out.println(line);
        }
        answer = regexCheck("^[yn]{0,1}$", this.wantToPlay().toLowerCase());
        if (answer.contains("Invalid")) {
            System.out.println(answer);
            return gameOverMenu();
        }
        return answer;
    }

    public String fightMenu(Player player, Room room) {
        try {
            String answer = "";
            String[] ascii = (Ascii.fight());
            for (String line : ascii) {
                System.out.println(line);
            }
            String str = 
                "You are in "+room.getName()+"\n"+
                "You can attack eather of these targets : \n";
            int index = 0;
            for (Caracter caracter : room.getNPC()) {
                str += "   ("+index+")"+caracter.getFullName()+"\n";
                index ++;
            }
            str += "   (B) You changed your mind. (go to previous menu)";
            System.out.println(str);
            answer = regexCheck("^[B]{1}|[0-9]{1,2}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")){
                throw new Exception(answer);
            }
            return answer;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return fightMenu(player, room);
        }
    }

    public String moveMenu(Player player, Game game) {
        String answer="";
        if (player.getPosition() == 0) {
            System.out.println( "Where do you want to go?\n"+
                        "   (N) Got to next room : "+game.board.getDungeon()[player.getPosition()+1].getName()+"\n"+
                        "\n"+
                        "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[NB]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        } else if (player.getPosition() == game.board.getDungeon().length-1) {
            System.out.println( "Where do you want to go?\n"+
                        "\n"+
                        "   (P) Got to previous room: "+game.board.getDungeon()[player.getPosition()-1].getName()+"\n"+
                        "   (B) You changed your mind. (go to previous menu)");
            answer = regexCheck("^[PB]{1}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")) {
                System.out.println(answer);
                return moveMenu(player, game);
            }
        } else {
            System.out.println( "Where do you want to go?\n"+
                    "   (N) Got to next room : "+game.board.getDungeon()[player.getPosition()+1].getName()+"\n"+
                    "   (P) Got to previous room: "+game.board.getDungeon()[player.getPosition()-1].getName()+"\n"+
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
        try {
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
            answer = regexCheck("^[B]{1}|[0-9]{1,2}$",this.scanner.nextLine().toUpperCase());
            if (answer.contains("Invalid")){
                    throw new Exception(answer);
            }
            return answer;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return searchRoomMenu(player, room);
        }
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
        str +="   (B) You changed your mind. (go to previous menu)\n"+
            "___________________________________________________________________________________________\n";
        System.out.println(str);
        answer = regexCheck("^[0-9B]{0,1}$",this.scanner.nextLine().toUpperCase());

        if (answer.contains("Invalid")) {
                System.out.println(answer);
                return inventoryMenu(player);
        }

        return answer;
    }

    public String itemInIventoryMenu(Player player, int index) {
        String answer = "";
        String str = "___________________________________________________________________________________________\n";
        str+= player.getInventory()[index].toString()+"\n";
        str+= player.getInventory()[index].getStats().toString()+"\n";
        str+=        "In your equipment now : \n";
        if (player.getEquipment().length!=0){
            for (Item item : player.getEquipment()) {
                if (item !=null){
                    str += "   "+ item.getMipple()+" "+item.getName()+"\n";
                    str+= item.getStats().toString()+"\n";
                } else {
                    str += "   "+"📦 Empty\n";}
            }
        }
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
        str +="   (B) You changed your mind. (go to previous menu)\n"+
            "___________________________________________________________________________________________\n";
        System.out.println(str);
        answer = regexCheck("^[0-9B]{0,1}$",this.scanner.nextLine().toUpperCase());

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
    public void levelUpMenu(Player player) {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "Congratulations "+player.getFullName()+" you have leveled up!\n"+
            "You are now level "+player.getLevel()+"\n"+
            "___________________________________________________________________________________________\n"
        );
    }
    public void noOneToFightMenu() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "There is no one to fight in this room\n"+
            "___________________________________________________________________________________________\n"
        );
    }
    public void noSuchItemMenu() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "There is no such item in this room\n"+
            "___________________________________________________________________________________________\n"
        );
    }
    public void noSuchEnemy() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "There is no such enemy in this room\n"+
            "___________________________________________________________________________________________\n"
        );
    }
    public void winMenu() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "Congratulations! You have won the game!\n"+
            "___________________________________________________________________________________________\n"
        );
    }
    public void noSuchItemInInventoryMenu() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "There is no such item in your inventory\n"+
            "___________________________________________________________________________________________\n"
        );
    }
    public String wishToUseCorpsMenu() {
        String answer = "";
        String str =
               "You stand over the lifeless creature, its body still and silent. Power tempts you, but the cost is high.\n" +
               "Will you defile the corpse to harvest its parts for your quest?\n" +
               "This act may grant you strength but at the price of your morality.\n\n" +
               "Do you wish to proceed? (y/N)\n\n" +
               "(Y) Yes, I will harvest the parts.\n" +
               "(N) No, I cannot desecrate the dead.";
        System.out.println(str);
        answer = regexCheck("^[YN]{0,1}$",this.scanner.nextLine().toUpperCase());
        if (answer.contains("Invalid")) {
                System.out.println(answer);
                return wishToUseCorpsMenu();
        }
        return answer;
    }
    public void defileCorpseMenu() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "You have harvested this corpse.\n"+
            "You feel power flowing throw you when you where it's skin on your armor.\n"+
            "The insides of this dead body are lying on the very ground of the room.\n"+
            "Traces of you barbaric behavior are all over the room.\n"+
            "As you look up to the door of the next room, you feel a vibration in the air.\n"+
            "An unexplicable feeling of sadness and anger is flowing trought the dungeon.\n"+
            "___________________________________________________________________________________________\n"
        );
    }
}