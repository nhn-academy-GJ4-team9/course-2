package org.example;

public class Ex3_1 {

    public static void main(String[] args) {

        int dice1, dice2;

        int count = 0;

        do {
            dice1 = (int)(Math.random()*6) + 1;
            dice2 = (int)(Math.random()*6) + 1;
            count++;
        } while ( dice1 != 1 || dice2 != 1 );

        System.out.println(count + "번 굴렸습니다.");

    }

}
