package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();


        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String ss = "";
            if (Character.isLetter(s.charAt(i))) {

                for (int j = i; j < s.length(); j++) {
                    if (!Character.isLetter(s.charAt(j)) || j == s.length() - 1) {
                        if (j == s.length() - 1) {
                            ss += s.charAt(j);
                        }
                        list.add(ss);
                        i = j;
                        break;
                    }
                    ss += s.charAt(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        scanner.close();

    }
}
