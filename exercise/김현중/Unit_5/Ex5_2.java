package org.example;

import java.util.Scanner;

public class Ex5_2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StatCalc calc = new StatCalc();
            double num;
            System.out.println("enter the number, enter 0 to end");
            do {
                num = sc.nextDouble();
                if(num != 0){
                    calc.enter(num);
                    System.out.println("you entered " + num);
                } else
                    System.out.println("you entered 0, end the prog");
            } while (num != 0);

            printResult(calc);
        }
    }

    public static void printResult(StatCalc calc) {
        System.out.println("Count : " + calc.getCount());
        System.out.println("sum : " + calc.getSum());
        System.out.println("max : " + calc.getMax());
        System.out.println("min : " + calc.getMax());
        System.out.println("avg : " + calc.getMean());
        System.out.println("standard deviation " + calc.getStandardDeviation());
    }
}
