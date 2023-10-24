package Ex_01;

import java.util.Random;

public class PairOfDice {

    private int dice1;
    private int dice2;

    public PairOfDice() {
        roll();
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    void roll() {
        Random random = new Random();
        this.dice1 = random.nextInt(6) + 1;
        this.dice2 = random.nextInt(6) + 1;
    }

    @Override
    public String toString(){

        return "dice1 : " + dice1 + "\tdice2 : " + dice2;
    }

}