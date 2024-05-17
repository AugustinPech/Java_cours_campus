package DonjonAndDragons2.src.models.Game;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DonjonAndDragons2.src.models.Game.Board.Room;
import DonjonAndDragons2.src.models.Caracters.Player.Playable;
import DonjonAndDragons2.src.models.Game.Board.Board;
import DonjonAndDragons2.src.views.Ascii;

public class Menu {
    private Scanner scanner;

    public Menu(InputStream source) {
        this.scanner = new Scanner(source);
    }
    private String regexCheck(String regex, String answer) throws IllegalArgumentException {
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

    public String chooseCaracterMenu() {
        try {
            System.out.println(
                "___________________________________________________________________________________________\n"+
                "Choose your class by typing : \n"+
                "(1) for Warrior\n"+
                "(2) for Wizard"+
                "___________________________________________________________________________________________"
            );
            
            String answer = regexCheck("^[12]{1}$",this.scanner.nextLine().toUpperCase());
            
            return answer;
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
        String answer = "";
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
    public String mainPhasemenu() {
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
            return mainPhasemenu();
        }
    }
    public void caracterSheetMenu(Playable player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'caracterSheetMenu'");
    }
    public void startTurnMenu(int turnNumber, Playable player) {
        System.out.println(
            "--------------------------------Turn n°"+turnNumber+"------------------------------------------\n"
        );
    }
    public void displayBoard(Board board, Playable player) {
        System.out.println(
            "----------------------------------BOARD----------------------------------------------------\n"
        );
        int position = 0;
        for (Room room : board.getDungeon()) {
            System.out.println("|| ");
            if (position == player.getPosition()) {
                System.out.print("🧍");
                System.out.println(room.toString());
            } else {
                System.out.print("🚪");
            }
            position++;
        }
        System.out.println(
            "-------------------------------------------------------------------------------------------"
        );
    }
}
