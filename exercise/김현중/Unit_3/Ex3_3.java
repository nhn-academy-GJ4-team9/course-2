package org.example;

import java.util.Scanner;

public class Ex3_3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double val1 = 0;
            double val2 = 0;
            String op = "";

            while (true) {
                System.out.println("input val1 :");
                val1 = sc.nextDouble();
                System.out.println("input op : ");
                op = sc.next();
                System.out.println("input val2 : ");
                val2 = sc.nextDouble();

                switch (op) {
                    case "+":
                        System.out.println(val1 + " + " + val2 + " = " + (val1 + val2));
                        break;
                    case "-":
                        System.out.println(val1 + " - " + val2 + " = " + (val1 - val2));
                        break;
                    case "*":
                        System.out.println(val1 + " - " + val2 + " = " + (val1 - val2));
                        break;
                    case "/":
                        System.out.println(val1 + " - " + val2 + " = " + (val1 - val2));
                        break;

                }
                if(sc.nextInt()==0)
                    break;
            }
        }
    }

}
