package org.example;

public class Ex4 {
    public static void main(String[] args) {
        printAvg();
    }

    /**
     * 2 부터 12까지 확률 출력하는 함수
     */
    private static void printAvg() {
        System.out.println("Total On Dice     Average Number of Rolls\n" +
                "-------------     -----------------------");
        for (int i = 2; i <= 12; i++) {
            System.out.println("      " + i + "            " + diceAvg(i));
        }
    }

    /**
     * input값이 나올수 있는 확률를 구하는 함수
     *
     * @param input
     * @return
     */
    private static double diceAvg(int input) {
        int count = 0;
        int sum = 0;

        while (count < 10000) {
            count++;
            sum += correctInput(input);
        }

        return (double) sum / 10000;
    }


    /**
     * 랜덤한 주사위값을 리턴하는 함수
     *
     * @return
     */
    private static int generateDice() {
        return (int) (Math.random() * 6) + 1;
    }


    /**
     * 주어진 input과 랜덤 수 dice와 dice2의 합이 같을 때까지 반복하다가
     * input과 dice+dice2가 같을 때 지금까지 카운트한 수를 반환하며 종료하는 함수
     *
     * @param input
     * @return
     */

    private static int correctInput(int input) {
        int dice = 0;
        int dice2 = 0;
        int inputCount = 0;

        while (true) {
            inputCount++;

            dice = generateDice();
            dice2 = generateDice();

            if (dice + dice2 == input) {
                break;
            }
        }

        return inputCount;
    }

}
