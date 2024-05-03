package DonjonAndDragons.src.models.items;

public abstract class Equipable extends Item{
    public Equipable(String name, String type) {
        super(name, type);
    }
    public Equipable(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
    }
}
