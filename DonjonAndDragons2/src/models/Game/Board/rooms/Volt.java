package DonjonAndDragons2.src.models.Game.Board.rooms;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;

public class Volt extends TresoreRoom {
    public Volt(int level) {
        super(level);
        this.setName("Volt");
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
