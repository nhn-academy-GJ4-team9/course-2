package org.example;

public class Ex5_1 {
    public static void main(String[] args) {
        PairOfDice dice;
        int rollcount = 0;

        dice = new PairOfDice();

        do {
            dice.roll();
            System.out.println("Roll " + rollcount + ": " + dice);
            rollcount++;
        } while (dice.getTotal() != 2);

        System.out.println(rollcount + " 번 돌려서 2가 나왔습니다.");
    }
}