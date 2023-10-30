package Ex_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("표현식 입력 : ");
            Expr expr = new Expr(scanner.nextLine());
            while (true) {
                System.out.print("x의값 입력 : ");
                double result = expr.value(scanner.nextInt());
                if (result == 0) {
                    break;
                }
                System.out.println(result);
            }
        }
    }
}