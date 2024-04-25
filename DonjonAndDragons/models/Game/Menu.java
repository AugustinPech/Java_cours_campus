package DonjonAndDragons.models.Game;
import DonjonAndDragons.models.Caracters.Player;
import DonjonAndDragons.models.Caracters.Warrior;
import DonjonAndDragons.models.Caracters.Wizard;
import DonjonAndDragons.models.Caracters.Caracter;
import DonjonAndDragons.models.items.Item;
import DonjonAndDragons.models.items.Weapon;
import DonjonAndDragons.views.Ascii;
import DonjonAndDragons.models.items.Armor;
import java.util.Scanner;

public class Menu {
    public Menu() {
        Scanner scanner = new Scanner(System.in);
        Ascii.printTitle();
        System.out.println("Do you want to join the adventure? (Y / n)");
        String answer = scanner.nextLine();
        switch (answer) {
            case "n":
                System.out.println("Goodbye");
                break;
            default:
                User user = new User();
                Caracter caracter = user.createCaracter();
                System.out.println("Welcome " + user.name + " the " + caracter.caracterClass + "!");
                break;
        }
    }
}
