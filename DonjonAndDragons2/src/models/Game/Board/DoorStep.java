package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.NPC.NPC;
import DonjonAndDragons2.src.views.Ascii;

public class DoorStep extends Room {

    public DoorStep() {
        super(0);
        this.setName("DoorStep");
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