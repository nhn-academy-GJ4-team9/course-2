package org.example;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int input = scanner.nextInt();
            int dice = generateDice();
            int dice2 = generateDice();
            try {
                if (!(input >= 2 && input <= 12)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 범위입니다.");
            }
            correctinput(dice, dice2, input);
        }
    }

    /**
     * 주어진 input과 랜덤 수 dice와 dice2의 합이 같으면 종료하는 함수
     *
     * @param dice
     * @param dice2
     * @param input
     * @return
     */
    private static int correctinput(int dice, int dice2, int input) {
        int count = 0;
        while (true) {
            count++;


            if (dice + dice2 == input) {
                System.out.println(dice + " + " + dice2 + " == " + input);
                System.out.println("count 수: " + count);
                break;
            } else {
                System.out.println(dice + " + " + dice2 + " != " + input);
            }

            dice = generateDice();
            dice2 = generateDice();

        }

        return count;
    }


    /**
     * 랜덤한 주사위값을 리턴하는 함수
     *
     * @return
     */
    private static int generateDice() {
        return (int) (Math.random() * 6) + 1;
    }


}
