package org.example;

import java.util.Scanner;

public class Ex5_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        StatCalc calc;
        calc = new StatCalc();

        double item;

        System.out.println("Enter your numbers.  Enter 0 to end.");
        System.out.println();

        do {
            System.out.print("? ");
            item = in.nextDouble();
            if (item != 0)
                calc.enter(item);
        } while (item != 0);

        System.out.println("Statistics about your data:");
        System.out.println("Count:" + calc.getCount());
        System.out.println("Sum:" + calc.getSum());
        System.out.println("Minimum:" + calc.getMin());
        System.out.println("Maximum:" + calc.getMax());
        System.out.println("Average:" + calc.getMean());
        System.out.println("Standard Deviation: " + calc.getStandardDeviation());

    }

}

