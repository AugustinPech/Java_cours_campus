package augustin.dnd;

public class Warrior {
    private String name;
    private int id;

    private int level;
    private int experience;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;

    public Warrior() {
        
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
