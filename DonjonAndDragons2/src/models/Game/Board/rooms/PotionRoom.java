package DonjonAndDragons2.src.models.Game.Board.rooms;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;

public class PotionRoom extends TresoreRoom {
    public PotionRoom(int level) {
        super(level);
        this.setName("Potion Room");
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
