import java.util.Scanner;

/**
 * Problem
 * 16진수를 10진수로 변환하는 문제
 * hexValue 함수를 만들고 switch 문을 사용해야함
 */
public class Ex_02 {

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();
            int result = 0;
            for (int i = 0; i < 2; i++) {
                int value = hexValue(input.charAt(i));
                if (value == -1) {
                    System.out.println("잘못된 값입니다.");
                    break;
                } else if (i == 0) {
                    result += 16 * value;
                } else {
                    result += value;
                }
            }
            System.out.println(result);
        }
    }

    public static int hexValue(char ch) {
        ch = Character.toUpperCase(ch);
        switch (ch) {
            case '0': {
                return 0;
            }
            case '1': {
                return 1;
            }
            case '2': {
                return 2;
            }
            case '3': {
                return 3;
            }
            case '4': {
                return 4;
            }
            case '5': {
                return 5;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 7;
            }
            case '8': {
                return 8;
            }
            case '9': {
                return 9;
            }
            case 'A': {
                return 10;
            }
            case 'B': {
                return 11;
            }
            case 'C': {
                return 12;
            }
            case 'D': {
                return 13;
            }
            case 'E': {
                return 14;
            }
            case 'F': {
                return 15;
            }
            default: {
                return -1;
            }
        }
    }
}