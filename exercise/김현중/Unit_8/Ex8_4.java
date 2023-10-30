package com.example.chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex8_4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("input exp : ");
            String exp;
            double x;

            while (true) {
                exp = sc.nextLine();
                Expr expr = new Expr(exp);
                System.out.println(expr +" ? ");
                System.out.println("input value to solve equation : " );
                x = sc.nextDouble();
                System.out.println(expr+ " ,x = " + x +" ," + "answer = "+expr.value(x));
                if (sc.nextLine().equals(""))
                    break;
            }
        } catch (IllegalArgumentException e){
            e.getMessage();
        } catch (InputMismatchException e){
            e.getMessage();
        }
    }
}
