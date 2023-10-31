package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);) {
            System.out.print("\n\nEnter a positive integer, or 0 to end:  ");
            int N = in.nextInt();
            BigInteger bigInteger = BigInteger.valueOf(N);
            System.out.println("\n  factorial(" + N + ") is " + factorial(bigInteger));
            System.out.println("\n  N is too big to compute fibonacci(N) recursively");
            System.out.println("\n  fibonacci(" + N + ") is " + fibonacci_nonrecursive(bigInteger) + "   (non-recursively)");
        }
    }

    private static BigInteger factorial(BigInteger bigInteger) {
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");

        if (bigInteger.equals(zero) || bigInteger.equals(one)) {
            return one;
        } else {
            return bigInteger.multiply(factorial(bigInteger.subtract(one)));
        }
    }


    private static BigInteger fibonacci_nonrecursive(BigInteger bigInteger) {
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");


        if (bigInteger.equals(zero) || bigInteger.equals(one)) {
            return one;
        } else {

            BigInteger sum = null;
            for (int i = 2; i <= bigInteger.intValue(); i++) {
                sum = zero.add(one);
                zero = one;
                one = sum;
            }

            return sum;
        }
    }


}
