package org.example;


import java.util.Arrays;

public class Ex2_6 {
    public static void main(String[] args) {
        TextIO.putln("Please enter your first name and last name, separated by a space.");
        String name = TextIO.getln();
        String[] names = name.split(" ");
        String first = names[0];
        String last= names[1];
        TextIO.putln("your first name is " + first + ",which has " + first.length() + " characters");
        TextIO.putln("your last name is " + last + ",which has " + last.length() + " characters");
        TextIO.putln("your initials " + first.substring(0,1).toUpperCase()+last.substring(0,1).toUpperCase());

    }
}
