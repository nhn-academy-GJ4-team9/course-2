package Ex_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stop = "n";

        while (!stop.equals("y")) {
            Double[] abc = new Double[3];
            for (int i = 0; i < 3 ; i++) {
                abc[i] = scanner.nextDouble();
            }
            System.out.println(root(abc[0], abc[1], abc[2]));
            System.out.println("그만 ? (y/n");
            stop = scanner.next();
        }
    }

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