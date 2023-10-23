package org.example;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {


        StatCalc calc = new StatCalc();

        System.out.println("Enter your numbers.  Enter 0 to end.\n");

        numberLoop(calc);

        System.out.println("\nStatistics about your data:\n");
        System.out.println(calc);


    }

    /**
     * 입력 받는 숫자가 0이 나올 때 까지 입력받은 값을 더하는 메서드
     * @param calc
     */
    private static void numberLoop(StatCalc calc) {
        try (Scanner in = new Scanner(System.in)) {
            double item = 0.0;
            do {
                System.out.print("숫자 입력: ");
                item = in.nextDouble();
                if (item != 0) {
                    calc.enter(item);
                }
            } while (item != 0);
        }
    }
}


class StatCalc {

    private int count;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.

    private double max;
    private double min;

    public StatCalc() {
        this.count = 0;
        this.sum = 0;
        this.squareSum = 0;
        this.max = Double.MIN_VALUE;
        this.min = Double.MAX_VALUE;
    }

    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num * num;
        if (num > this.max) {
            this.max = num;
        }

        if (num < this.min) {
            this.min = num;
        }
    }

    public int getCount() {
        return count;
    }

    public void setSquareSum(double squareSum) {
        this.squareSum = squareSum;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public double getMean() {
        if (getCount() <= 0) {
            throw new ArithmeticException();
        }

        return sum / count;
    }

    public double getStandardDeviation() {

        if (getCount() <= 0) {
            throw new ArithmeticException();
        }
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

    public double getMax() {

        return this.max;
    }

    public double getMin() {
        return this.min;
    }

    @Override
    public String toString() {
        return "StatCalc{" +
                "\n\tcount= " + getCount() +
                "\n\tsum= " + getSum() +
                "\n\tStandardDeviation= " + getStandardDeviation() +
                "\n\tmax= " + getMax() +
                "\n\tmin= " + getMin() +
                "\n}";
    }
}  // end class StatCalc