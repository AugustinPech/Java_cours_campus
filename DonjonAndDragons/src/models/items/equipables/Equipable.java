package DonjonAndDragons.src.models.items.equipables;

import DonjonAndDragons.src.models.items.Item;

public abstract class Equipable extends Item{
    private Boolean isEquiped = false;
    public Boolean getIsEquiped() {
        return isEquiped;
    }
    public void setIsEquiped(Boolean isEquiped) {
        this.isEquiped = isEquiped;
    }
    public Equipable(String name, String type) {
        super(name, type);
    }
    public Equipable(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
    }
    public Equipable(int roll) {
        super(roll);
    }
    public Equipable(int roll, int level) {
        //TODO Auto-generated constructor stub
    }
}
