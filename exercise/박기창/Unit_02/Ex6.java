package org.example;


import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("Please enter your first name and last name, separated by a space.");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //String s = TextIO.getln();

        s = s.replaceAll(" +", " ");
        s = s.substring(s.indexOf(" ") + 1);

        String sung = s.substring(0, s.indexOf(" "));
        String name = s.substring(s.indexOf(" ") + 1);


        System.out.println("Your last name is " + sung + ", which has " + sung.length() + " characters");
        System.out.println("Your last name is " + name + ", which has " + name.length() + " characters");
        System.out.println("Your initials are " + sung.charAt(0) + name.charAt(0));

    }
}
