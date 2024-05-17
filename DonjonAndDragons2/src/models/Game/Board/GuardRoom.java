package DonjonAndDragons2.src.models.Game.Board;

import java.util.ArrayList;
import java.util.List;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.NPC.Gobelin;
import DonjonAndDragons2.src.models.Caracters.NPC.NPC;
import DonjonAndDragons2.src.models.Caracters.NPC.Orc;

public class GuardRoom extends FightRoom {

    public GuardRoom(int level) {
        super(level);
        this.setName("Guard Room");
        int roll = (int) Math.floor((Math.random() * 5));
        int points = roll + level;
        ArrayList<Caracter> npc = new ArrayList<Caracter>();
            npc.add(new Gobelin(level));
            npc.add(new Orc(level));
        // int rand = (int) Math.floor((Math.random() * points));
        // int remainingPoints = points - rand;

        // while (remainingPoints>=0) {
        //     npc.add(new Gobelin(rand));
        //     npc.add(new Orc(rand));

        //     rand = (int) Math.floor((Math.random() * remainingPoints));
        //     remainingPoints = points - rand;
        // }
        this.setNpcs(npc);
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
