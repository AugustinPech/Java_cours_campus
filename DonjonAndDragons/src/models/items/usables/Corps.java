package DonjonAndDragons.src.models.items.usables;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.Player.Player;

public class Corps extends Usable{
    private String name;
    private int level;
    public Corps (Caracter caracter)  {
        super(caracter.getName()+"'s corps", "corps");
        this.name=caracter.getName();
        this.stats=new Stats(0,1,0,2,0,0);
        this.status = "deadBody";
        this.level = caracter.getLevel();
        this.setMipple("💀");
    }
    public Insides[] use(Player player){
        String name = this.name;
        
            Insides[] insides = {
                new Insides(this, "heart"),
                new Insides(this, "brain"),
                new Insides(this, "liver"),
                new Insides(this, "lungs"),
                new Insides(this, "eyes"),
            };
        
        return insides;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
