package org.example;

import java.util.Scanner;

public class Ex2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String input = scanner.nextLine();

        String[] n = input.split(" ");

        if (n.length == 2) {
            String a = n[0];
            String b = n[1];
            int lastname = a.length();
            int name = b.length();

            System.out.println("귀하의 성은 " + lastname + "글자입니다.");
            System.out.println("귀하의 이름은 " + name + "글자입니다.");
            System.out.println("이니셜은 " + a.charAt(0) + b.charAt(0));
        }
    }
}
