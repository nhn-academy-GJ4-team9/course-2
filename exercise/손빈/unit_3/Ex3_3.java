package org.example;

import java.util.Scanner;

public class Ex3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산식을 입력하세요");

        double a = scanner.nextDouble();
        char op = scanner.next().charAt(0);
        double b = scanner.nextDouble();

        double result = 0.0;

        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
        }

        System.out.println("결과: " + result);
        scanner.close();
    }
}

