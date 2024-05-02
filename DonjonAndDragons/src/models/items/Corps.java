package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Caracters.Caracter;

public class Corps extends Item{
    public Corps (Caracter caracter)  {
        super( caracter.getName()+ "'s corps", "corps");
        this.status = "deadBody";
        this.setMipple("💀");
    }

}
