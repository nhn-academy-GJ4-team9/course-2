package Ex_02;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        char exp = 0;
        while (true) {
            boolean AB = true;
            String input = scanner.nextLine();
            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i)) && AB) {
                    A.add(Integer.parseInt(input.charAt(i) + ""));
                } else if (Character.isDigit(input.charAt(i)) && !AB) {
                    B.add(Integer.parseInt(input.charAt(i) + ""));
                }
                if (input.charAt(i) == '+' || input.charAt(i) == '*' || input.charAt(i) == '-') {
                    exp = input.charAt(i);
                    AB = false;
                }
            }
            if (exp == 0) {
                System.out.println("Invalid expression");
            } else {
                cal(A, B, exp);
            }

            A.clear();
            B.clear();
        }

    }

    public static void cal(TreeSet A, TreeSet B, char exp){
        switch(exp){
            case '+' :
                A.addAll(B);
                break;
            case '*' :
                A.retainAll(B);
                break;
            case '-' :
                A.removeAll(B);
                break;
            default: throw new IllegalArgumentException();

        }

        System.out.println(A.toString());
    }




}
