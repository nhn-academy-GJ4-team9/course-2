package org.example;

import java.util.Arrays;

public class Ex4_4 {
    public static void main(String[] args) {
        System.out.println("total on dice     average number of rolls");
        System.out.println("========================================");
        int[] totalValue = totalValue();
        int[] count = countRolls();

        double[] avg = new double[11];
        for(int i = 0 ; i< count.length;i++){
            avg[i] = count[i];
            System.out.println(totalValue[i] +"                 " + avg[i]);
        }
    }

    public static int newDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public static boolean isGivenNumber(int givenNum, int sumOfDice) {
        if (givenNum == sumOfDice)
            return true;
        else
            return false;
    }

    public static void isValid(int n) {
        if (n < 2 || n > 12)
            throw new IllegalArgumentException("not valid");
    }

    public static int addDice() {
        int dice1 = newDice();
        int dice2 = newDice();
        return dice1 + dice2;
    }

    public static int[] countRolls() {
        int n[] = totalValue();
        int count[] = new int[11];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < n.length; j++) {
                boolean isGivenNum = isGivenNumber(n[j], addDice());
                if (isGivenNum) {
                    count[j]++;
                }
            }
        }
        return count;
    }

    public static int[] totalValue() {
        int[] totalValue = new int[11];
        for (int i = 0; i <= 10; i++) {
            totalValue[i] = i + 2;
        }
        return totalValue;
    }


}
