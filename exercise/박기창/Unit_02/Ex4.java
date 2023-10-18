package org.example;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        //쿼터가 0.25 다임 0.1 니켈 0.05 페니 0.01


        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt(); // 1쿼터  0.25달려
        int d = scanner.nextInt(); // 1다임  0.1 달러
        int n = scanner.nextInt(); // 1니켈  0.05달러
        int p = scanner.nextInt(); // 1페니  0.01달러


        double result = 0.0;

        result = result + q * 0.25;
        result = result + d * 0.1;
        result = result + n * 0.05;
        result = result + p * 0.01;

        System.out.println(result);


    }
}
