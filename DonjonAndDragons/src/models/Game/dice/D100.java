package DonjonAndDragons.src.models.Game.dice;

public class D100 implements Dice{
    public int rollDie() {
        return (int) (Math.random() * 100);
    }
}
