package org.example;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < count; i++) {
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("The " + i + 1 + " die comes up " + dice);
            result += dice;
        }

        System.out.println("Your total roll is " + (result));


    }
}
