package org.example;

public class Ex5_1 {
    public static void main(String[] args) {
       PairOfDice pairOfDice = new PairOfDice();
       do{
           pairOfDice.roll();
           System.out.println(pairOfDice);
       } while (pairOfDice.getDice1() != pairOfDice.getDice2());
        System.out.println("you rolled " + pairOfDice.getCount());
    }
}
