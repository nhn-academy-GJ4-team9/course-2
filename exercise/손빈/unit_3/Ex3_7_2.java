package org.example;

public class Ex3_7_2 {

    public static void main(String[] args) {

        int[] used;

        int count;

        used = new int[365];

        count = 0;

        while (true) {
            int birthday;
            birthday = (int)(Math.random()*365);
            count++;
            System.out.printf("Person %d has birthday number %d%n", count, birthday);

            if (count == 365) {
                break;
            }
            used[birthday]++;
        }

        int day = 0;

        for (int i = 0; i < used.length; i++) {
            if (used[i] != 0) {
                day++;
            }
        }
        System.out.println(day);
    }

}
