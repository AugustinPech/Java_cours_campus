package DonjonAndDragons2.src.models.Caracters.Player;


import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.damages.Normal;

public class Warrior extends Playable implements Fighter, Player {

    public Warrior(String name) {
        super(name);
        this.setStats(new Stats(
            150, 
            2, 
            5, 
            1,
            2,
            2,
            0
        ));
    }

    @Override
    public void pickUpItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickUpItem'");
    }

    @Override
    public void dropItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dropItem'");
    }

    @Override
    public void equipItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equipItem'");
    }

    @Override
    public void unequipItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unequipItem'");
    }

    @Override
    public void useItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    @Override
    public void levelUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'levelUp'");
    }

    @Override
    public Damage attack(Caracter target) {
        //todo : choice of the weapon
        Damage damage = new Normal(this.getStats(), this.getLevel());

        return damage;
    }

    @Override
    public void defend(Damage damage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }
   
}
