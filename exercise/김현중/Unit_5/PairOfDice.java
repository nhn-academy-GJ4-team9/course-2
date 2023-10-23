package org.example;

public class PairOfDice {
    private int dice1;
    private int dice2;
    private static int count = 0;
    private static final int EXPERIMENT_TIMES = 10000;


    public PairOfDice() {
        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = (int) (Math.random() * 6 + 1);
    }

    public int getDice1() {
        return this.dice1;
    }

    public int getDice2() {
        return this.dice2;
    }
    public void roll(){
        this.dice1 = (int) (Math.random()*6+1);
        this.dice2 = (int) (Math.random()*6+1);
        count++;
    }

    @Override
    public String toString() {
        return "dice 1 = " + getDice1() + " dice 2 = " + getDice2();
    }

    public int getCount() {
        return count;
    }
    public int sumOfDice(){
        return this.dice1 + this.dice2;
    }


}
