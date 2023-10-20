package org.example;

public class Ex7_3 {
    public static void main(String[] args) {
        int[] used;

        int count = 0;

        int eachcount = 0;

        used = new int[365];


        while (eachcount < 365) {

            int birthday;
            birthday = (int) (Math.random() * 365); // 0 ~ 364  --->365개
            count++;
            if (used[birthday] == 0) {
                eachcount++;
            }
            used[birthday]++;
        }

        System.out.println(count);
    }
}
