package org.example;

import java.util.Scanner;

public class Ex8_3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력하세요:");
        int number = scanner.nextInt();
        String roman = convertToRoman(number);
        System.out.println("로마 숫자: " + roman);

        System.out.println("로마 숫자를 입력하세요:");
        scanner.nextLine();
        String romanInput = scanner.nextLine();
        int convertedNumber = convertToNumber(romanInput);
        System.out.println("숫자: " + convertedNumber);

        scanner.close();
    }

    public static String convertToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(romanNumerals[i]);
                number -= values[i];
            }
        }
        return roman.toString();
    }

    public static int convertToNumber(String roman) {
        int number = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = romanToNumber(roman.charAt(i));

            if (value < prevValue) {
                number -= value;
            } else {
                number += value;
            }

            prevValue = value;
        }

        return number;
    }

    public static int romanToNumber(char numeral) {
        switch (numeral) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
