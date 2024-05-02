package DonjonAndDragons.src.models.items;

public class Potion extends Item {
    public int heal;

    public Potion(String name, int heal) {
        super(name, "Potion");
        this.heal = heal;
    }

}
