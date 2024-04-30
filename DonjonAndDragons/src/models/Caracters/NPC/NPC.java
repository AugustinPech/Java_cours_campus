package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;

public class NPC extends Caracter {
    public Boolean isOstile;
    public NPC(String name, Game game, Boolean isOstile) {
        super(name);
        this.isOstile = isOstile;
        this.sprite= "웃";
    }
    public Boolean setIsOstile(Boolean bool){
        return this.isOstile = bool;
    }
}
