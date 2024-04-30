package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.*;
public class Wizard extends Player{

    public Wizard(String name, Game game) {
        super(name, game);
        this.caracterClass = "Wizard";
        this.type = "spellCaster";
        this.sprite="🌈";
        this.setFullName();
        this.addItem(new Weapon(this.caracterClass));
        this.equipItem(0);
        this.addItem(new Armor(this.caracterClass));
        this.equipItem(0);
    }
}
