package org.example;

public class PairOfDice {

    private int die1;
    private int die2;

    public PairOfDice() {
        roll();
    }

    public void roll() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

    public int getTotal() {
        return die1 + die2;
    }

    @Override
    public String toString() {
        if (die1 == die2) {
            return die1 + " and " + die2;
        }
        return die1 + " and " + die2;
    }
}


