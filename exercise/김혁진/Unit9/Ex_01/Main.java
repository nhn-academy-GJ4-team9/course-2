package Ex_01;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n < 0) {
                System.out.println("음수는 입력할 수 없습니다.");
            } else {
                System.out.println("팩토리얼 : " + factorial(n));
                System.out.println("피보나치 : " + fibo(n));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수는 처리할 수 없습니다.");
        }
        if (n == 0) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static BigInteger fibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수는 처리할 수 없습니다.");
        }
        if (n < 2) {
            return BigInteger.ONE;
        }
        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ONE;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        return fib[n];
    }
}
