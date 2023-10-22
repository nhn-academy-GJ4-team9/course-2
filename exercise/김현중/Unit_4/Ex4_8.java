package org.example;

import java.lang.annotation.Native;
import java.util.Scanner;

public class Ex4_8 {
    static int[] VAL1 = new int[10];
    static int[] VAL2 = new int[10];
    static int[] ANSWER = new int[10];

    public static void main(String[] args) {
        System.out.println("Open Quiz");
        createQuiz();
        administerQuiz();
        gradeQuiz();

    }

    private static void gradeQuiz() {
        int grade = 0;
        for(int i =0 ; i< 10 ; i++){
            grade += ANSWER[i];
        }
        System.out.println("your score is " + grade);
    }


    public static void createQuiz() {
        for (int i = 0; i < 10; i++) {
            VAL1[i] = (int) (Math.random() * 100);
            VAL2[i] = (int) (Math.random() * 100);
        }
    }
    public static void administerQuiz() {
        try(Scanner sc = new Scanner(System.in)){
            for(int i = 0; i <10 ;i++){
                System.out.printf("Q%d : %d + % d = ? ",i,VAL1[i],VAL2[i]);
                ANSWER[i] = sc.nextInt();
                if(ANSWER[i] == VAL1[i] + VAL2[i]){
                    System.out.println("Correct");
                    ANSWER[i] = 10;
                } else {
                    System.out.println("Wrong");
                    ANSWER[i] = 0;
                }
            }
        }
    }
}
