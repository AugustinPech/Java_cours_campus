package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;

public abstract class NPC extends Caracter {
    private Boolean isOstile;
    public NPC(String name, Game game, Boolean isOstile, int position) {
        super(name);
        this.setPosition(position);
        this.isOstile = isOstile;
        this.setSprite("웃");
    }
    public Boolean getIsOstile(){
        return this.isOstile;
    }
    public Boolean setIsOstile(Boolean bool){
        return this.isOstile = bool;
    }
}
