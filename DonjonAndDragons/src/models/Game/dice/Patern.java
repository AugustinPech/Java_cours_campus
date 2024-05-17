package DonjonAndDragons.src.models.Game.dice;

public class Patern implements Dice{
    public int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
    public int[] predeterminedPatern(String difficulty){
        int[] patern = new int[10];
        switch (difficulty) {
            case "normal" ->{
            }
            case "hard" -> {
            }
        }
        return patern;
    };
}
