package com.example.chapter8;

import java.util.Scanner;

public class Ex8_1 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String end;
                do {
                    System.out.println("To solve equation, input A,B,C");
                    System.out.println("input A : ");
                    double A = sc.nextDouble();
                    System.out.println(A);
                    System.out.println("input B : ");
                    double B = sc.nextDouble();
                    System.out.println(B);
                    System.out.println("input C : ");
                    double C=  sc.nextDouble();
                    System.out.println(C);
                    System.out.print("answer : ");
                    System.out.println(root(A,B,C));
                    System.out.println("to end enter 'no' or press anything and enter");
                    end = sc.next();

                } while (!end.equals("no"));



        }
    }
    static public double root(double A, double B, double C) throws IllegalArgumentException{
        if(A==0){
            throw new IllegalArgumentException("A Can't be zero");
        } else {
            double disc = B* B - 4 * A*C;
            if(disc<0)
                throw new IllegalArgumentException("Discriminant < zero");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }



}
