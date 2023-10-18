package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_4 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
           String line = sc.nextLine();
           String[] words = line.split(" ");
           for(int i = 0 ;i< words.length-1;i++){
               System.out.println(words[i].replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]",""));
           }

        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
