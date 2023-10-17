package org.example;

import java.util.Scanner;

public class Ex2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("how many eggs do you have : ");
        int eggs = sc.nextInt();
        int gross = eggs / 144;
        int dozens = (eggs % 144) / 12;
        int rest = eggs % 12;
        System.out.println("your number of eggs is " + gross+ "gross, " + dozens + ",dozen and " + rest);



    }

}
