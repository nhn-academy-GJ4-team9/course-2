package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_2 {
    public static void main(String[] args) {
        System.out.println("your total rool is " + roll());
    }

    public static int roll() {
        int sum = 0;
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int num = (int) (Math.random() * 6) + 1;
                System.out.println("die comes up " + num);
                sum += num;
            }
            return sum;
        } catch (InputMismatchException e) {
            System.out.println("0 이상 정수 입력");

        }
        return sum;
    }
}
