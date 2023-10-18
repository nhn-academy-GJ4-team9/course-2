package org.example;

public class Ex6 {
    public static void main(String[] args) {

        int[] result = new int[10001];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    result[i]++;
                }
            }
        }

        int max = 0;
        int N = 0;
        for (int i = 1; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
                N = i;
            }
        }


        System.out.println("Among integers between 1 and 10000,");
        System.out.println("The maximum number of divisors was " + max);
        System.out.println("Numbers with that many divisors include:");
        for (int i = 1; i < result.length; i++) {
            if (result[i] == result[N]) {
                System.out.println(i);
            }
        }


    }
}
