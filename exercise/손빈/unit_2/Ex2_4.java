package org.example;

import java.util.Scanner;

public class Ex2_4 {
    public static void main(String[] args) {
        int quarters, dimes, nickels, pennies;

        double dollar;
        Scanner scanner = new Scanner(System.in);

        System.out.println("쿼터의 갯수: ");
        quarters = scanner.nextInt();
        scanner.nextLine();

        System.out.println("다임의 갯수: ");
        dimes = scanner.nextInt();
        scanner.nextLine();

        System.out.println("니켈의 갯수: ");
        nickels = scanner.nextInt();
        scanner.nextLine();

        System.out.println("페니의 갯수: ");
        pennies = scanner.nextInt();
        scanner.nextLine();

        dollar = (0.25 * quarters) + (0.10 * dimes) + (0.05 * nickels) + (0.01 * pennies);
        System.out.println(dollar);

    }
}
