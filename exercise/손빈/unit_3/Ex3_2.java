package org.example;

public class Ex3_2 {
    public static void main(String[] args) {
        int max = 0;
        int number = 0;

        for (int i = 1; i <= 10000; i++) {
            System.out.print(i + " 의 약수 : ");
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    System.out.print(j + ", ");
                    count++;
                }
            }
            System.out.println();
            if (count > max) {
                max = count;
                number = i;
            }
        }
        System.out.println("가장 약수가 많은 정수: " + number);
    }
}

