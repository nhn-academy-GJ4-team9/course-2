package org.example;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        while (true) {

            double first = scanner.nextDouble();
            char op = scanner.next().charAt(0);
            double second = scanner.nextDouble();
            double sum = 0.0;

            if (first == 0) {
                break;
            }

            switch (op) {
                case '+':
                    sum = first + second;
                    break;
                case '-':
                    sum = first - second;
                    break;
                case '*':
                    sum = first * second;
                    break;
                case '/':
                    sum = first / second;
                    break;
            }

            System.out.println(first + " " + op + " " + second + " = " + sum);

        }


        scanner.close();
    }
}
