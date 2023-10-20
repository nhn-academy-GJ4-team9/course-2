package org.example;

public class Ex3_1 {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            int dice1 = (int) (Math.random() * 6) + 1;
            System.out.printf("dice 1 is %d%n", dice1);
            int dice2 = (int) (Math.random() * 6) + 1;
            System.out.printf("dice 2 is %d%n", dice2);
            System.out.println();

            count++;
            if (dice1 == 1 && dice2 == 1)
                break;
        }
        System.out.printf("you rolled %d times", count);
    }
}