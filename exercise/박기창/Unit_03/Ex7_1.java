package org.example;

public class Ex7_1 {
    public static void main(String[] args) {

        int[] used;

        int count;

        used = new int[365];

        count = 0;

        while (true) {


            int birthday;
            birthday = (int) (Math.random() * 365);
            count++;
            System.out.printf("Person %d has birthday number %d%n", count, birthday + 1);

            used[birthday]++;

            if (used[birthday] == 3) {
                break;
            }
        }

        System.out.println();
        System.out.println("같은 날 생일인 사람 3명 찾기 "
                + count + " 시도 끝에 성");
    }
}
