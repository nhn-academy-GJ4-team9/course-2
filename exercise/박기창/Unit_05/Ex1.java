package org.example;

public class Ex1 {
    public static void main(String[] args) {


        PairOfDice firstDice = new PairOfDice();

        PairOfDice secondDice = new PairOfDice();

        int countRolls = 0;

        countRolls = countMethod(firstDice, secondDice);

        System.out.println("It took " + countRolls + " rolls until the totals were the same.");
    }

    /**
     * 두 쌍의 주사위를 던저서 두 쌍의 주사위 합이 같은 값이 나오면 지금까지 카운트 했던 수를 반환하면서 종료하는 메서드
     *
     * @param firstDice
     * @param secondDice
     * @return
     */
    private static int countMethod(PairOfDice firstDice, PairOfDice secondDice) {
        int countRolls = 0;

        while (true) {
            firstDice.roll();
            System.out.println("First pair comes up  " + firstDice.getSum());

            secondDice.roll();
            System.out.println("Second pair comes up " + secondDice.getSum() + "\n");

            countRolls++;

            if (firstDice.getSum() == secondDice.getSum()) {
                break;
            }


        }

        return countRolls;
    }

}

/**
 * 한 쌍의 주사위 클래스
 */
class PairOfDice {

    private int die1;
    private int die2;

    public PairOfDice() {
        roll();
    }


    public int getSum() {
        return this.getDie1() + this.getDie2();
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }


    public void roll() {
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
    }


}
