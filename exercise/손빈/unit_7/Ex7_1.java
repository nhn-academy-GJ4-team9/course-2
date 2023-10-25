package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Ex7_1 {
    public static ArrayList<Integer> RandomInteger(int count, int maxValue) {
        ArrayList<Integer> randomIntegers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            randomIntegers.add(rand.nextInt(maxValue));
        }
        return randomIntegers;
    }

    public static void main(String[] args) {
        int number = 10;
        int maxValue = 100;

        ArrayList<Integer> randomInteger = RandomInteger(number, maxValue);

        System.out.println("무작위 정수 (1에서 " + maxValue + "까지):");
        System.out.println(randomInteger);
    }
}
