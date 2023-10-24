package Ex_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StatCalc statCalc = new StatCalc();
        try (Scanner scanner = new Scanner(System.in)) {

            double value = 1;

            while (!isInputZero(value)) {
                System.out.println("값을 입력 하세요");
                value = scanner.nextDouble();
                statCalc.enter(value);
            }

            System.out.println(statCalc);
        }
    }

    public static boolean isInputZero(double value) {
        return value == 0;
    }
}

