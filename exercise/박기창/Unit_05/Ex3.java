package org.example;

public class Ex3 {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();
        PairOfDice firstDice = new PairOfDice();
        printAvg(calc, firstDice);
    }


    /**
     * 두 주사위의 합이 2 부터 12까지 나올 확률을 출력하는 함수
     */
    private static void printAvg(StatCalc calc, PairOfDice firstDice) {
        System.out.println("Total On Dice     Average Number of Rolls               표준편차                   최대 롤 수 \n" +
                "-------------     -----------------------               ------                   --------");
        for (int i = 2; i <= 12; i++) {
            System.out.println(
                    "      " + i + "            " + diceAvg(i, calc, firstDice) + "    \t\t\t\t\t " +
                            calc.getStandardDeviation() + "\t\t\t\t\t" + calc.getMax());
        }
    }


    /**
     * input값이 나올 수 있는 확률를 구하는 함수
     *
     * @param input
     * @return
     */
    private static double diceAvg(int input, StatCalc calc, PairOfDice firstDice) {
        int count = 0;
        int sum = 0;

        calc.setMax(Double.MIN_VALUE);
        calc.setCount(0);
        calc.setMin(Double.MAX_VALUE);
        calc.setSum(0);
        calc.setSquareSum(0);

        while (count < 10000) {
            count++;
            calc.enter(correctInput(input, firstDice));
        }

        return calc.getMean();
    }
    /**
     * 주어진 input과 랜덤 수 dice와 dice2의 합이 같을 때까지 반복하다가
     * input과 dice+dice2가 같을 때 지금까지 카운트한 수를 반환하며 종료하는 함수
     *
     * @param input
     * @return
     */

    private static int correctInput(int input, PairOfDice firstDice) {
        int inputCount = 0;

        while (true) {
            inputCount++;

            firstDice.roll();

            if (firstDice.getSum() == input) {
                break;
            }
        }

        return inputCount;
    }
}
