package org.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            printCapitalized(input);
        }
    }

    /**
     * 문자열의 각 단어 맨 앞 문자를 대문자로 변환해주는 메소드
     *
     * @param input
     */
    private static void printCapitalized(String input) {
        String[] result = input.split(" ");
        StringBuffer resultbuffer = new StringBuffer();
        for (String a : result) {
            resultbuffer.append(Character.toUpperCase(a.charAt(0)));
            resultbuffer.append(a.substring(1));
            resultbuffer.append(" ");
        }
        System.out.println(resultbuffer.toString());
    }
}