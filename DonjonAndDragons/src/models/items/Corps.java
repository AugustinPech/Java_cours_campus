package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.Player.Player;

public class Corps extends Usable{
    private String name;
    public Corps (Caracter caracter)  {
        super( caracter.getName()+"'s corps", "corps");
        this.name=caracter.getName();
        this.stats=new Stats(0,1,0,2,0,0);
        this.status = "deadBody";
        this.setMipple("💀");
    }
    public Insides[] use(Player player){
        String name = this.name;
        if (name.contains("Gobelin")){
            Insides[] insides = {
                new Insides("Gobelin's heart", "heart"),
                new Insides("Gobelin's brain", "brain"),
                new Insides("Gobelin's liver", "liver"),
                new Insides("Gobelin's lungs", "lungs"),
                new Insides("Gobelin's eyes", "eyes"),
                new Insides("Gobelin's ears", "ears"),
            };
            return insides;
        } else {
            Insides[] insides = {
                new Insides(name+"'s heart", "heart"),
                new Insides(name+"'s brain", "brain"),
                new Insides(name+"'s liver", "liver"),
                new Insides(name+"'s lungs", "lungs"),
                new Insides(name+"'s eyes", "eyes"),
            };
            return insides;
        }
    }
}
