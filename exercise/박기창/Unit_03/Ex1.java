package org.example;

public class Ex1 {
    public static void main(String[] args) {


        int dicefirst = 0;
        int dicesecond = 0;
        int count = 0;
        while (true) {
            dicefirst = (int) (Math.random() * 6) + 1;
            dicesecond = (int) (Math.random() * 6) + 1;

            System.out.println("첫 번째 주사위 값: " + dicefirst);
            System.out.println("두 번째 주사위 값: " + dicesecond);

            count++;

            if (dicefirst == 1 && dicesecond == 1) {
                break;
            }

        }
        System.out.println(count);
    }
}
