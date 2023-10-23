package org.example;

import java.util.Scanner;

public class Ex4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문장을 입력하세요: ");
        String input = scanner.nextLine();

        if (input != null) {
            String[] words = input.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                if (!word.isEmpty()) {
                    char firstChar = Character.toUpperCase(word.charAt(0));
                    String rest = word.substring(1);
                    String capitalize = firstChar + rest;
                    result.append(capitalize).append(" ");
                }
            }
            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }
            System.out.println("결과: " + result);
        } else {
            System.out.println("유효한 입력이 아닙니다.");
        }

        scanner.close();
    }
}

