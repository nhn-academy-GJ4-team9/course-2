package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String n = scanner.nextLine();
            try {
                BigInteger N = new BigInteger(n);
                System.out.println(threeNone(N));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     *
     * C(n+1) = C(n)/2     (C(n)이 짝수일 때)
     *        = 3*C(n)+1   (C(n)이 홀수일 때)
     *
     * C(N)==1 이 될 때 N값 반환하고 종료
     * @param N
     * @return
     */
    private static int threeNone(BigInteger N) {

        int count = 1;
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");

        if (N.toString().equals("1")) {
            return count;
        }

        while (true) {
            if (N.toString().equals("1")) {
                break;
            }
            if (N.testBit(0)) {
                count++;
                N = N.multiply(three);
                N = N.add(one);
            } else {
                count++;
                N = N.divide(two);
            }
        }

        return count;
    }


}
