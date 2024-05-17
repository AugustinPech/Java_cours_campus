package DonjonAndDragons2.src.models.Game.Board.dice;

public class D20 implements Dice{
    public int rollDie() {
        return (int) (Math.random() * 20);
    }
}
