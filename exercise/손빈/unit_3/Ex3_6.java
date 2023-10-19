package org.example;

public class Ex3_6 {
    public static void main(String[] args) {
        int maxcount = 0;
        int[] numbers = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > maxcount) {
                maxcount = count;
                numbers = new int[10000];
                numbers[0] = i;
            } else if (count == maxcount) {
                numbers[count] = i;
            }
        }
        System.out.println("1부터 10000 사이의 정수 중");
        System.out.println("최대 약수 수는 " + maxcount + "개입니다.");
        System.out.println("약수가 많은 숫자는 다음과 같습니다:");

        for (int i = 0; i <= maxcount; i++) {
            if (numbers[i] != 0) {
                System.out.println(numbers[i]);
            }
        }
    }
}
