package org.example;

import java.util.Scanner;

public class Ex2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many quaters do you have? : ");
        int q = sc.nextInt();
        System.out.print("How many dimes do you have? : ");
        int d = sc.nextInt();
        System.out.print("How many nickels do you have? : ");
        int n = sc.nextInt();
        System.out.print("How many pennies do you have? : ");
        int p = sc.nextInt();

        double dollars = q/4 + d/10 + n/5 + p/100 ;
        System.out.println("your changes are : " + dollars);
        sc.close();


    }
}
