package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;

public class HallWay extends Room {

    public HallWay() {
        super(0);
        this.setName("HallWay");
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
