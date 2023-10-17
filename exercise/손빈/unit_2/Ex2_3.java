package org.example;

import java.util.Scanner;

public class Ex2_3 {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String i = scanner.next().toUpperCase();

        System.out.println("Hello," + i + ", nice to meet you!");
    }
}
