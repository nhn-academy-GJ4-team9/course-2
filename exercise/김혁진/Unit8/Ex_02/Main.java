package Ex_02;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * n = 3n+1   홀수
 * n = n/2    짝수
 * 입력 6
 * 6
 * 3
 * 10
 * 5
 * 16
 * 8
 * 4
 * 2
 * 1
 */

public class Main {
    static BigInteger ZERO = new BigInteger("0");
    static BigInteger ONE = new BigInteger("1");
    static BigInteger TWO = new BigInteger("2");
    static BigInteger THREE = new BigInteger("3");

    public static void main(String[] args) {

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String n = scanner.nextLine().trim();
                BigInteger N = new BigInteger(n);
                if (n.length() == 0) {
                    break;
                } else {
                    collaz(N);
                }
            } catch (NumberFormatException e) {
                System.out.println("다시 입력 하세요");
            }
        }
    }

    static void collaz(BigInteger N) {
        while (!N.equals(ONE)) {
            if (N.mod(TWO).equals(ZERO)) {
                N = N.divide(TWO);
            } else {
                N = N.multiply(THREE);
                N = N.add(ONE);
            }
            System.out.println(N);
        }
    }
}