package DonjonAndDragons.src.models.Game.Board;

import java.util.ArrayList;
import java.util.List;

import DonjonAndDragons.src.models.Caracters.NPC.Gobelin;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.NPC.Orc;

public class GuardRoom extends Room {
    public GuardRoom (Board board, int level) {
        super();
        int roll = (int) Math.floor((Math.random()*5));
        int points = roll + level;
        ArrayList<NPC> npc = new ArrayList<NPC>();
        if (points <=5) {
            npc.add(new Gobelin("Gobelin", board, level));
        } else if (points <=10) {
            npc.add(new Orc("Orc", board, level));
        } else {
            int numberOfPaires=(int) points/2;
            for (int i = 0; i < numberOfPaires; i++) {
                npc.add(new Gobelin("Gobelin", board, level));
                npc.add(new Orc("Orc", board, level));
            }
        }
        this.NPCfromList(npc);
    }
}
