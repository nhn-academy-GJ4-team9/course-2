package org.example;

import java.text.MessageFormat;
import java.util.Scanner;

public class Ex4_3 {
    public static int rolledDice(int range) {
        return (int) (Math.random() * range) + 1;
    }

    public static int simulateDice(int total) {
        try{
            if (total < 2 || total > 12) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.err.println("올바르지 않습니다.");
            return 0;
        }

        int count = 0;
        int sum = 0;

        do {
            int roll1 = rolledDice(6);
            int roll2 = rolledDice(6);
            count++;
            sum = roll1 + roll2;
            System.out.println(MessageFormat.format("Roll {0}: dice 1 = {1}, dice 2 = {2}, sum = {3}", count, roll1, roll2, sum));
        } while (sum != total);

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("2부터 12까지의 숫자를 선택하세요.");
        int value = scanner.nextInt();

        int rolls = simulateDice(value);
        System.out.printf(rolls+" 번");

    }
}
