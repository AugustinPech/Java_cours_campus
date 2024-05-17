package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;


public class BossRoom extends FightRoom{

    public BossRoom(String name, String description, int level) {
        super(level);
        this.setName(name);
    }

    public BossRoom(int level) {
        super(level);
        this.setName("Boss Room");        
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
