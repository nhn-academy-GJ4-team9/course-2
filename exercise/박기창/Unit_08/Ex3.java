package org.example;

import java.util.Scanner;

public class Ex3 {


    private static int[] numbers = {1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1};

    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"};


    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("아라비아 숫자를 넣으면 로마숫자로 바꿔줌");
            System.out.print("아라비아 숫자입력: ");

            arabiaToRoma(scanner);

            System.out.println("로마 숫자를 입력하면 아라비아 숫자로 바꿔줌 ");
            System.out.print("로마 숫자 입력: ");

            romaToArabia(scanner);

        }


    }

    private static void romaToArabia(Scanner scanner) {
        try {
            String roman = scanner.nextLine();
            int n = 0;
            for (int i = 0; i < roman.length(); i++) {
                char c = roman.charAt(i);
                int num = numbersIndex(c);

                i++;
                if (i == roman.length()) {
                    n += numbers[num];
                } else {

                    char c2 = roman.charAt(i);
                    int num2 = numbersIndex(c2);
                    if (numbers[num2] > numbers[num]) {
                        n += numbers[num2] - numbers[num];
                    } else {
                        i--;
                        n += numbers[num];
                    }
                }

            }

            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void arabiaToRoma(Scanner scanner) {
        try {

            int number = scanner.nextInt();
            scanner.nextLine();
            String roman = "";

            for (int i = 0; i < numbers.length; i++) {
                while (number >= numbers[i]) {
                    roman += letters[i];
                    number = number - numbers[i];
                }
            }
            System.out.println(roman);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 해당 문자를 기지고 있는 numbers의 인덱스 위치를 알려주는 메서드
     * @param c
     * @return
     */
    private static int numbersIndex(char c) {

        switch (c) {
            case 'M':
                return 0;
            case 'D':
                return 2;
            case 'C':
                return 4;
            case 'L':
                return 6;
            case 'X':
                return 8;
            case 'V':
                return 10;
            case 'I':
                return 12;
            default:
                throw new NumberFormatException();
        }
    }
}
