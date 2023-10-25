package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String def = scanner.nextLine();
            try{
                Expr expr = new Expr(def);
                double d = scanner.nextDouble();
                System.out.println(expr);
                System.out.println(expr.value(d));



            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
