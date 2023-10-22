package org.example;

import java.util.Scanner;

public class Ex4_3 {
    public static void main(String[] args) {
        System.out.print("input valid number (2<n<12) :");
        try (Scanner sc = new Scanner(System.in)) {
            int givenNum = sc.nextInt();
            int count=0;
            while (true){
                isValid(givenNum);
                int dice1 = newDice();
                int dice2 = newDice();
                System.out.println("dice1 is " + dice1 + " dice 2 is " + dice2);
                if(isGivenNumber(givenNum,dice1+dice2)){

                    System.out.println("you tried " + count);
                    break;
                }
                else
                    count++;
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static int newDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public static boolean isGivenNumber(int givenNum, int sumOfDice) {
        if (givenNum == sumOfDice)
            return true;
        return false;
    }

    public static boolean isValid(int n) {
        if (n < 2 || n > 12)
            throw new IllegalArgumentException("Impossible total for a pair of dice");
        else
            return true;
    }


}
