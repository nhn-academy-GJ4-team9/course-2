package org.example;
import java.math.BigInteger;
import java.util.Scanner;

public class Ex8_2 {
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line;

        BigInteger N;

        System.out.println("숫자를 입력학세요.");

        while (true) {
            System.out.println();
            System.out.println("시작 값 입력하거나 Enter 키를 눌러 종료하세요.");
            System.out.print("? ");
            line = scanner.nextLine().trim();
            if (line.length() == 0)
                break;
            try {
                N = new BigInteger(line);
                if (N.signum() == 1)
                    printThreeNSequence(N);
                else
                    System.out.println("오류: 시작 값은 0보다 작거나 같을 수 없습니다.");
            } catch (NumberFormatException e) {
                System.out.println("오류: " + line + "는 유효한 정수가 아닙니다.");
            }
        }
        System.out.println("프로그램을 종료합니다. 안녕히 가십시오!");

    }

    private static void printThreeNSequence(BigInteger N) {

        assert N != null && N.signum() == 1 : "부적절한 매개변수 값입니다.";

        int count;

        System.out.println();
        System.out.println(N + "으로 시작하는 3N+1 수열은:");
        System.out.println();

        System.out.println(N);
        count = 1;

        while (!N.equals(ONE)) {
            if (N.testBit(0) == false) {
                N = N.divide(TWO);
            } else {
                N = N.multiply(THREE);
                N = N.add(ONE);
            }
            System.out.println(N);
            count++;
        }

        System.out.println();
        System.out.println("수열에는 총 " + count + "개의 항목이 있습니다.");
    }
}
