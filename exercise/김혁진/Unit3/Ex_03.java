import java.io.IOException;
import java.util.Scanner;

/**
 * Problem
 * 입력 받은 값을 연산하는 문제
 */
public class Ex_03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String[] inputStream = scanner.nextLine().split(" ");
                if (inputStream[0].equals("0")) {
                    break;
                } else {
                    System.out.println("결과값 : " + calculator(inputStream));
                }
            }
        }
    }

    /**
     * 입력받은 식을 계산하는 메서드
     * case or if
     * @param inputStream
     * @return 값을 계산하여 출력
     */
    public static double calculator(String[] inputStream) {
        double result = Double.parseDouble(inputStream[0]);
        for (int i = 1; i < inputStream.length; i += 2) {
            if (i + 1 < inputStream.length) {
                double operand = Double.parseDouble(inputStream[i + 1]);
                if (inputStream[i].equals("+")) {
                    result += operand;
                } else if (inputStream[i].equals("-")) {
                    result -= operand;
                } else if (inputStream[i].equals("*")) {
                    result *= operand;
                } else if (inputStream[i].equals("/")) {
                    result /= operand;
                }
            }
        }
        return result;
    }
}