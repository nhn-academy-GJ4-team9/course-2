package org.example;

import java.util.Scanner;

public class Ex4_2 {
    public static int hexValue(char c) {
        c = Character.toUpperCase(c);
        if (Character.isDigit(c)) {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        } else {
            return -1;
        }
    }
    public static int hexadecimal(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            int digitValue = hexValue(str.charAt(i));
            if (digitValue == -1) {
                return -1;
            }
            value = value * 16 + digitValue;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("16진수 문자열을 입력하세요: ");
        String hexStr = scanner.nextLine();

        int decimalValue = hexadecimal(hexStr);

        if (decimalValue == -1) {
            System.out.println("오류: 입력에 유효하지 않은 문자가 포함되어 있습니다.");
        } else {
            System.out.println("10진수 값: " + decimalValue);
        }
    }
}
