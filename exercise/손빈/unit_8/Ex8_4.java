package org.example;

import java.util.Scanner;

public class Ex8_4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        Expr expression;
        double x;
        double val;

        System.out.println("이 프로그램은 지정된 변수 x의 값에서 특정 함수 f(x)를 계산합니다.");
        System.out.println("f(x)의 정의에서 +, -, *, / 및 ^와 같은 연산자,");
        System.out.println("sin, abs 및 ln과 같은 수학 함수를 사용할 수 있습니다.");

        while (true) {

            System.out.println("\n\n\nf(x)의 정의를 입력하거나 Enter 키를 눌러 종료합니다.");
            System.out.print("\nf(x) = ");
            line = scanner.nextLine().trim();
            if (line.length() == 0)
                break;

            try {
                expression = new Expr(line);
            }
            catch (IllegalArgumentException e) {

                System.out.println("오류! f(x)의 정의가 유효하지 않습니다.");
                System.out.println(e.getMessage());
                continue;
            }


            System.out.println("\nf(x)를 계산할 변수 x의 값을 입력합니다.");
            System.out.println("종료하려면 Enter 키를 누릅니다.");

            while (true) {
                System.out.print("\nx = ");
                line = scanner.nextLine().trim();
                if (line.length() == 0)
                    break;
                try {
                    x = Double.parseDouble(line);
                }
                catch (NumberFormatException e) {
                    System.out.println("\"" + line + "\"는 유효한 숫자가 아닙니다.");
                    continue;
                }
                val = expression.value(x);
                if (Double.isNaN(val))
                    System.out.println("f(" + x + ")는 정의되지 않습니다.");
                else
                    System.out.println("f(" + x + ") = " + val);
            }

        }

        System.out.println("\n\n\n좋아요. 잠시 후 다시 만나요.");

    }

}
