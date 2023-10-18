package org.example;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int egg = scanner.nextInt();

        int grocss = egg / 144;
        int dozen = (egg % 144) / 12;
        int rest = (egg % 144) % 12;

        System.out.println("Your number of eggs is " + grocss + " gross, " + dozen + " dozen, and " + rest);
    }
}
