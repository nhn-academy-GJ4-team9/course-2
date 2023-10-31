package org.example;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Set<Integer> s1 = new TreeSet();
            Set<Integer> s2 = new TreeSet();

            System.out.println("s1 입력" );
            while(true){
                String s = scanner.nextLine();
                if("".equals(s))break;
                s1.add(Integer.parseInt(s));
            }

            System.out.println("s2 입력");
            while(true){
                String s = scanner.nextLine();
                if("".equals(s))break;
                s2.add(Integer.parseInt(s));
            }


            System.out.println("The operator, +, *, or -.\n");
            char op = scanner.nextLine().charAt(0);

            switch (op){
                case '+':
                    s1.addAll(s2);
                    System.out.println(s1);
                    break;
                case '*':
                    s1.retainAll(s2);
                    System.out.println(s1);
                    break;
                case '-':
                    s1.removeAll(s2);
                    System.out.println(s1);
                    break;

            }



        }

    }


}
