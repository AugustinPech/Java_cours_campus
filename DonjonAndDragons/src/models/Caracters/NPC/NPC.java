package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.equipables.Armor;
import DonjonAndDragons.src.models.items.equipables.Weapon;
import DonjonAndDragons.src.models.items.usables.Potion;

public abstract class NPC extends Caracter {
    private Boolean isOstile;
    public NPC(String name, Boolean isOstile, int position) {
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
    public Item[] randomLoot(){
        Item[] loot = this.getInventory();
        for (int i = 0; i < loot.length && i < this.getLevel()+1; i++) {
            int roll = (int) Math.floor((Math.random()*50));
            Weapon weapon = new Weapon (roll, this.getLevel());
            Armor armor = new Armor (roll, this.getLevel());
            Potion potion = new Potion (roll, this.getLevel());
            if (roll%3==0) {
                loot[i] = weapon;
            } else if (roll%3==1) {
                loot[i] = armor;
            } else {
                loot[i] = potion;
            }
        }
        return loot;
    }
}
