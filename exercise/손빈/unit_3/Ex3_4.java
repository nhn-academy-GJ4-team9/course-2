package org.example;
import java.util.Scanner;

public class Ex3_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");
        String inputText = scanner.nextLine();

        String[] words = inputText.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
        scanner.close();
    }
}


