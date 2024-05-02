package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Potion extends Item {

    public Potion(String name, String potionType) {
        super(name, "Potion");
        switch (potionType) {
            case "Health" -> {
                int heal = (int) (Math.random()*10 + 10);
                this.setName("Heal Potion");
                this.mipple = "♡";
                this.stats= new Stats(heal , 0, 0, 0, 0);
            }
            case "Protection" -> {
                this.setName("Protection Potion");
                this.mipple = "🧪";
                int armor = (int) (Math.random()*10+5);
                this.stats= new Stats(0 , armor, 0, 0, 0);
            }
        }
    }

}
