package org.example;

import java.util.Scanner;

public class Ex5_6 {

    static int[] ANSWER = new int[10];
    private static AdditionQuestion[] questions;

    public static void main(String[] args) {
        System.out.println("Open Quiz");
        createQuiz();
        administerQuiz();
        gradeQuiz();


    }

    private static void gradeQuiz() {
        int grade = 0;
        for(int i =0 ; i< 10 ; i++){
            if(ANSWER[i] == questions[i].getCorrectAnswer()){
                grade += 10;
            }
        }
        System.out.println("your score is " + grade);
    }


    public static void createQuiz() {
        questions = new AdditionQuestion[10];
        for (int i = 0; i < 10; i++) {
            questions[i]= new AdditionQuestion();
        }
    }
    public static void administerQuiz() {
        ANSWER = new int[10];
        try(Scanner sc= new Scanner(System.in)){
            int qn = 1;
            for(int i = 0 ; i<10;i++){
                System.out.printf("Q %d : %s",qn,questions[i].getQuestion());
                qn++;
                ANSWER[i] = sc.nextInt();
            }
        }
    }
}
