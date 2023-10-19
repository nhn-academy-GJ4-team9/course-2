import java.io.IOException;
import java.util.Scanner;

/**
 * Problem
 * n을 입력받고 1 부터 n 까지 가장 많은 약수를 갖은 숫자 출력
 */
public class Ex_02 {
    public static void main(String[] args) {
        System.out.print("n의 값 입력 : ");
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            int maxValue = 0;
            int maxCount = 0;
            for (int i = number / 2; i <= number; i++) {
                if (maxCount <= divCount(i)) {
                    maxValue = i;
                    maxCount = divCount(i);
                }
            }
            System.out.println("가장 많은 정수 : " + maxValue + ", 약수의 개수 : " + maxCount);
        }
    }

    /**
     * 약수의 개수를 구하는 메서드
     *
     * @param n 정수
     * @return 입력받은 정수가 가지는 약수의 개수 출력
     */
    public static int divCount(int n) {
        int count = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
