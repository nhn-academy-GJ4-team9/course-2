package org.example;

// 제수가 가장 많은 수는?
// 제수란 10 % 5 = 2 에서 5 즉 약수

public class Ex2 {
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

        System.out.println("제수가 가장 많은 수: " + N + " 제수 개수: " + max);

    }
}
