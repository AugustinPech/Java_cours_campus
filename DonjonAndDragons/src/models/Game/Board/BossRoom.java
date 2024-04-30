package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.Caracters.NPC.Dragon;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Game.Game;

public class BossRoom extends Room{
    public BossRoom(Game game){
        this.name = "Boss Room";
        this.npcs = new NPC[1];
        this.npcs[0]=new Dragon(game);
        this.greatMsg = "As you cautiously push open the heavy stone door, a wave of heat washes over you, carrying with it the acrid scent of smoke and charred wood. The dim light of flickering torches barely penetrates the thick shadows that shroud the cavernous chamber. The ground trembles beneath your feet with each heavy footstep, and the air is filled with the low rumble of a distant growl. In the center of the room, atop a mound of glittering treasure, lies the majestic form of the ancient dragon, its scales glistening in the dim light as it surveys its domain with smoldering eyes. You can feel the weight of its gaze upon you, and the primal fear that grips your heart tells you that this is no ordinary beast - this is the legendary guardian of the treasure hoard, the fearsome dragon that has struck fear into the hearts of adventurers for generations.";
    }
}
