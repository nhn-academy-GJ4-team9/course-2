package org.example;

import java.util.Scanner;

public class Ex8_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;

        while (again) {
            try {
                System.out.print("A 값을 입력하세요: ");
                double A = scanner.nextDouble();
                System.out.print("B 값을 입력하세요: ");
                double B = scanner.nextDouble();
                System.out.print("C 값을 입력하세요: ");
                double C = scanner.nextDouble();
                double solution = root(A, B, C);

                System.out.println("방정식의 해: " + solution);

                System.out.print("다른 방정식을 계산하시겠습니까? (y/n): ");
                String response = scanner.next();
                again = response.equals("y");
            } catch (IllegalArgumentException e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
        System.out.println("프로그램 종료");
    }

    public static double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A는 0이 될 수 없습니다.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }
}
