package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4_1 {
    public static void main(String[] args) {
        System.out.print("input line : ");
        try (Scanner sc = new Scanner(System.in)){
            String str = sc.nextLine();
            printCapitalized(str);

        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public static void printCapitalized(String str) {
        System.out.println(capitalize(splitLineToWord(str)));
    }

    public static String[] splitLineToWord(String str) {
        String[] strings = str.split(" ");
        return strings;
    }

    public static String capitalize(String[] strings) {
        String line = "";
        for(int i = 0; i< strings.length;i++){
            if(strings[i].isEmpty()){
                strings[i]= strings[i];
            } else {
                strings[i]= String.valueOf(strings[i].charAt(0)).toUpperCase() + strings[i].substring(1);
            }
        }
        return line = String.join(" ",strings);


    }

}
