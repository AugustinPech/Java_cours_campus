package DonjonAndDragons.src.models.Game;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.Warrior;
import DonjonAndDragons.src.models.Caracters.Wizard;
public class User {
    public User() {
        try {
            System.out.println("User created");
        } catch (Exception e) {
            System.out.println("Error creating user");
        }
    }

    public Caracter createCaracter(String[] answerFromMenu, Game game) {
        try {
            String className = answerFromMenu[0];
            String charName = answerFromMenu[1];
            switch (className){
                case "A":
                    return new Warrior(charName, game);
                case "Z":
                    return new Wizard(charName, game);
                default:
                    throw new IllegalArgumentException("Invalid input: " + className);
        }
        } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return createCaracter(answerFromMenu,game);
        }
    }
}
