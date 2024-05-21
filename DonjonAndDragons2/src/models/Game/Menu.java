package DonjonAndDragons2.src.models.Game;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DonjonAndDragons2.src.models.Game.Board.Room;
import DonjonAndDragons2.src.models.items.Item;
import DonjonAndDragons2.src.models.items.equipables.Equipable;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.Player.Playable;
import DonjonAndDragons2.src.models.Caracters.Player.Player;
import DonjonAndDragons2.src.models.Caracters.Player.Warrior;
import DonjonAndDragons2.src.models.Caracters.Player.Wizard;
import DonjonAndDragons2.src.models.Game.Board.Board;
import DonjonAndDragons2.src.views.Ascii;

public class Menu {
    private Scanner scanner;

    public Menu(InputStream source) {
        this.scanner = new Scanner(source);
    }
    public String regexCheck(String regex, String answer) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new IllegalArgumentException("Invalid input : "+ answer +"\nPlease try again");
        }
        return answer;
    }

    public String getDifficulty() {
        try {
            System.out.println("Choose a difficulty: easy, medium, hard");
            String answer = this.scanner.nextLine().toUpperCase();

            // System.out.println("(" + answer+ ")");
            answer = regexCheck("^(?:EASY|MEDIUM|HARD)$",answer);
            return answer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getDifficulty();
        }
    }

    public Player.PlayerType chooseCaracterMenu() {
        try {
            System.out.println(
                "___________________________________________________________________________________________\n"+
                "Choose your class by typing : \n"+
                "(1) for Warrior\n"+
                "(2) for Wizard\n"+
                "___________________________________________________________________________________________"
            );
            
            String answer = regexCheck("^[12]{1}$",this.scanner.nextLine().toUpperCase());
            

            if(answer.equals("1")){
                return Player.PlayerType.WARRIOR;
            }else if(answer.equals("2")){
                return Player.PlayerType.WIZARD;
            }else{
                throw new UnsupportedOperationException("Invalid class");
            }
           
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return chooseCaracterMenu();
        }
    }


    public String chooseNameMenu() {
        System.out.println("Choose your name");
        return this.scanner.nextLine();
    }
    public void winMenu() {
        System.out.println(
            "___________________________________________________________________________________________\n"+
            "Congratulations! You have won the game!\n"+
            "___________________________________________________________________________________________\n"
        );
    }

    public void gameOverMenu() {
        String[] ascii = (Ascii.gameOver());
        for (String line : ascii) {
            System.out.println(line);
        }
    }
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public String mainPhaseMenu() {
        try {
            System.out.println(
                "----------------------------------MAIN-PHASE-----------------------------------------------\n"+
                "   Choose your action by typing : \n"+
                "       (ENTER) to proceed to the next phase\n"+
                "       (C) to see your Caractersheet (does not skip your turn)\n"+
                "       (I) to see your Inventory\n"+
                "       (E) to see your Equipment\n"+                
                "       (Q) to quit the game\n"+
                "-------------------------------------------------------------------------------------------"
            );
            String answer = regexCheck("^[CIEQ]{0,1}$",this.scanner.nextLine().toUpperCase());
            return answer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mainPhaseMenu();
        }
    }
    public void caracterSheetMenu(Caracter caracter) {
        System.out.println(
            "----------------------------------CARACTER-SHEET-------------------------------------------\n"+
            "      Name: "+caracter.getName()+"    Class: "+caracter.getCaracterClass()+"      Level: "+caracter.getLevel()+"\n"+
            caracter.getStats().toString()+"\n"+
            "----------------------------------EQUIPMENT------------------------------------------------\n"+
            this.showEquipment(caracter.getEquipment())+
            "----------------------------------INVENTORY------------------------------------------------\n"+
            this.showInventory(caracter.getInventory())+
            "-------------------------------------------------------------------------------------------\n"
        );
    }
    private String showEquipment(ArrayList<Equipable> items) {
        String str = "";
        int index =0;
        if (items == null || items.size() == 0) {
            str += "No equipment\n";
        } else {
            for (Item item : items) {
                str += "("+ index + ")";
                str += item.toString();
                index ++;
                if (index % 2 ==0) {
                    str += "\n";
                }
            }
        }
        return str;
    }
    private String showInventory(ArrayList<Item> items) {
        String str = "";
        int index =0;
        if (items == null || items.size() == 0) {
            str += "No equipment\n";
        } else {
            for (Item item : items) {
                str += "("+ index + ")";
                str += item.toString();
                index ++;
                if (index % 2 ==0) {
                    str += "\n";
                }
            }
        }
        return str;
    }

    public void startTurnMenu(int turnNumber, Playable player, Board board) {
        System.out.println(
            "----------------------------------Turn n°"+turnNumber+"--------------------------------------------\n"
        );
        System.err.println(
            "       You are in "+board.getDungeon().get(player.getPosition())+"\n"
        );
    }
    public void displayBoard(Board board, Playable player) {
        System.out.println(
            "----------------------------------BOARD----------------------------------------------------\n"
        );
        int position = 0;
        for (Room room : board.getDungeon()) {
            System.out.print("|| ");
            if (position == player.getPosition()) {
                System.out.print("[Player]");
                System.out.print(room.toString());
            } else {
                System.out.print("[no-see]");
            }
            System.out.print(" ||");
            position++;
        }
        System.out.println(
            "\n-------------------------------------------------------------------------------------------"
        );
    }
    public String inventoryMenu(ArrayList<Item> inventory) {
       try {
            System.out.println(
                "----------------------------------INVENTORY------------------------------------------------\n"+
                this.showInventory(inventory)+
                "   Choose an item by typing its index or :\n"+
                "       (B) to go back to previous menu\n"+
                "       (ENTER) to proceed\n"+
                "-------------------------------------------------------------------------------------------"
            );
            String answer = this.scanner.nextLine().toUpperCase();

            // System.out.println("(" + answer+ ")");
            answer = regexCheck("^[0-9]{0,2}|B$",answer);
            return answer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inventoryMenu(inventory);
        }
    }
    public void noSuchItem(String noMatchIndex) {
        System.out.println("Input : " + noMatchIndex +"\nNo such item in your inventory\n");
    }
    public String itemInteractionInventoryMenu(Item item) {
        try {
            System.out.println(
                "----------------------------------ITEM-INTERACTION-----------------------------------------\n"+
                item.toString()+
                "   Choose an action by typing :\n"+
                "       (E) Equip\n"+
                "       (U) to use the item\n"+
                "       (D) to drop the item\n"+
                "       (B) to go back to previous menu\n"+
                "       (ENTER) to proceed\n"+
                "-------------------------------------------------------------------------------------------"
            );
            String answer = this.scanner.nextLine().toUpperCase();

            // System.out.println("(" + answer+ ")");
            answer = regexCheck("^[UDEB]{0,1}$",answer);
            return answer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return itemInteractionInventoryMenu(item);
        }
    }
}
