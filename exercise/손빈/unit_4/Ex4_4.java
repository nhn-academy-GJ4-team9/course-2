package org.example;

import java.text.MessageFormat;
import java.util.Scanner;

public class Ex4_4 {
    public static int rolledDice(int range) {
        return (int) (Math.random() * range) + 1;
    }

    public static double calculateAverage(int total, int numRolls) {
        try{
            if (total < 2 || total > 12 || numRolls <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.err.println("올바르지 않습니다.");
            return 0.0;
        }

        int count = 0;
        int sum = 0;
        int desiredCount = 0;

        for (int i = 0; i < numRolls; i++) {
            int roll1 = rolledDice(6);
            int roll2 = rolledDice(6);
            count++;
            sum = roll1 + roll2;
            System.out.println(MessageFormat.format("Roll {0}: dice 1 = {1}, dice 2 = {2}, sum = {3}", count, roll1, roll2, sum));

            if (sum == total) {
                desiredCount++;
            }
        }

        return (double) desiredCount / numRolls;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("2부터 12까지의 숫자를 선택하세요: ");
        int value = scanner.nextInt();

        System.out.print("주사위를 몇 번 굴릴까요? ");
        int numRolls = scanner.nextInt();

        double average = calculateAverage(value, numRolls);
        System.out.printf("평균 나오는 횟수: %.2f%n", average);
    }
}
