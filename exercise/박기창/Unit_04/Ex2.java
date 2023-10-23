package org.example;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            int value = 0;
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                value = value * 16 + hexValue(str.charAt(i));
            }

            System.out.println(value);
        }
    }


    /**
     * 문자가 들어오면 해당 문자를 16진수로 바꿔주는 메소드
     *
     * @param input
     * @return
     */
    private static int hexValue(char input) {

        if (input >= '1' && input <= '9') {
            return input - '0';
        } else if (input >= 'a' && input <= 'f') {
            return input - 87;
        } else if (input >= 'A' && input <= 'F') {
            return input - 55;
        } else {
            return -1;
        }
    }
}
