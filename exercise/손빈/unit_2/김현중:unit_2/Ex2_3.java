package org.example;

import java.util.Scanner;

public class Ex2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name : ");
        String name = sc.nextLine();
        sc.close();
        System.out.println("Hello," + name + ", nice to meet you");

    }
}
