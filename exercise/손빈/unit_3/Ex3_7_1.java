package org.example;

public class Ex3_7_1 {

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
            used[birthday]++;
            if ( used[birthday] == 3) {
                break;
            }
        }
        System.out.println();
        System.out.println(count + "번");
    }

}
