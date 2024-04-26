package DonjonAndDragons.src.models.Caracters;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.*;
import DonjonAndDragons.src.views.Ascii;
public class Wizard extends Player{

    public Wizard(String name, Game game) {
        super(name, game);
        this.caracterClass = "Wizard";
        this.type = "spellCaster";
        this.sprite=Ascii.wizardSprite();
        this.mipple="🪄";
        this.setFullName();
        this.addItem(new Weapon(this.caracterClass));
        this.equipItem(0);
        this.addItem(new Armor(this.caracterClass));
        this.equipItem(0);
        this.createStatsView();

    }
}
