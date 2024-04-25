package DonjonAndDragons.models.Caracters;
import DonjonAndDragons.models.items.Item;
import DonjonAndDragons.models.items.Weapon;
import DonjonAndDragons.models.items.Armor;
import DonjonAndDragons.models.Caracters.Caracter;
public class Warrior extends Player{
    public Warrior(String name) {
        super(name);
        this.caracterClass = "Warrior";
        this.setFullName();
        this.addItem(new Weapon(this.caracterClass));
        this.equipItem(0);
        this.addItem(new Armor(this.caracterClass));
        this.equipItem(0);        
    }
}
