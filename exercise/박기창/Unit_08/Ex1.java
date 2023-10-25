package org.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {


        double a, b, c;

        boolean restart = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (restart) {
                System.out.print("A 값을 입력: ");
                a = scanner.nextDouble();
                System.out.print("B 값을 입력: ");
                b = scanner.nextDouble();
                System.out.print("C 값을 입력: ");
                c = scanner.nextDouble();

                try {
                    System.out.println(root(a, b, c));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("더 하실건가요? true or false");
                restart = scanner.nextBoolean();

            }


        }
    }




    /**
     * 이차 방정식 근 구하는 메서드
     * @param A
     * @param B
     * @param C
     * @return
     * @throws IllegalArgumentException
     */
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0) {
                throw new IllegalArgumentException("Discriminant < zero.");
            }
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }
}