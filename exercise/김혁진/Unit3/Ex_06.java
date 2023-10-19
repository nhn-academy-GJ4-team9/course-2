import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem
 * 최대 약수를 갖는 숫자를 모두 출력
 */
public class Ex_06 {
    public static void main(String[] args) {
            System.out.print("n의 값 입력 : ");
            try(Scanner scanner = new Scanner(System.in)){
            int number = scanner.nextInt();
            int maxCount = 0;
            List<Integer> arrayList = new ArrayList<>();

            for (int i = number / 2; i <= number; i++) {
                int divisorCount = divCount(i);

                if (divisorCount > maxCount) {
                    maxCount = divisorCount;
                    arrayList.clear();
                    arrayList.add(i);
                } else if (divisorCount == maxCount) {
                    arrayList.add(i);
                }
            }

            System.out.println("1부터 n 사이의 정수 최대 약수 갯수 :" + maxCount);
            System.out.println("약수가 많은 숫자");
            for (int i : arrayList) {
                System.out.println(i);
            }
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
