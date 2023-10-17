package org.example;

import java.util.Scanner;

public class Ex2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 계란 수를 입력하세요: ");
        int egg = scanner.nextInt();

        int a = egg / 144;
        int m = egg % 144;
        int b = m / 12;
        int c = m % 12;

        System.out.println("계란 수는 총 " + a + "개, 다스 " + b + "개," + " 남은 계란 " + c + "개 입니다.");
    }
}







