package DonjonAndDragons.models.Game;
import DonjonAndDragons.models.Caracters.Caracter;
import DonjonAndDragons.models.Caracters.Warrior;
import DonjonAndDragons.models.Caracters.Wizard;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User {
    public String name;
    public User() {
        try {
            this.setName();
            System.out.println("User created with name: " + name);
        } catch (Exception e) {
            System.out.println("Error creating user");
        }
    }
    public void setName() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = input.nextLine();

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]{1,20}$");
        Matcher matcher = pattern.matcher(userName);

        if (!matcher.find()) {
            System.out.println("Invalid username");
            this.setName();
        } else {
            this.name = userName;
        }
    }
    public Caracter createCaracter() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose your class by typing : \n (A) for Warrior\n (B) for Wizard");
            String className = input.nextLine();
            System.out.println("Choose the name of your character");
            String charName = input.nextLine();

            switch (className ){
                case "A":
                    return new Warrior(charName);
                case "B":
                    return new Wizard(charName);
                default:
                    throw new IllegalArgumentException("Invalid input: " + input);
        }
        } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return createCaracter();
        }
    }
}
