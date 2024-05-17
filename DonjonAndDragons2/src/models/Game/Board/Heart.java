package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.NPC.Guardian;
import DonjonAndDragons2.src.models.Caracters.NPC.NPC;

public class Heart extends Room {

    public Heart(int level) {
        super(level);
        this.setName("Heart");
    }

    @Override
    public void enterRoom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterRoom'");
    }

    @Override
    public void leaveRoom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leaveRoom'");
    }
        @Override
    public ArrayList<Caracter> getCaracters() {
        return this.getNpcs();
    }
    
}
