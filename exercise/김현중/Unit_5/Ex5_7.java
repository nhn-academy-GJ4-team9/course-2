package org.example;

import java.util.Scanner;

public class Ex5_7 {
    private static IntQuestion[] questions;
    private static int[] ANSWER;

    public static void main(String[] args) {
        createQuiz();
        administerQuiz();
        gradeQuiz();


    }

    private static void gradeQuiz() {
        int grade = 0;
        for (int i = 0; i < 10; i++) {
            if (ANSWER[i] == questions[i].getCorrectAnswer()) {
                grade += 10;
            }
        }
        System.out.println("your score is " + grade);
    }


    public static void createQuiz() {
        questions = new IntQuestion[10];
        for (int i = 0; i < 5; i++) {
            questions[i] = new SubtractionQuestion();
        }
        for (int i = 5; i < 9; i++) {
            questions[i] = new AdditionQuestion();
        }
        questions[9] = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "What is the answer to the ultimate question " + "of life, the universe, and everything? ";
            }

            @Override
            public int getCorrectAnswer() {
                return 42;
            }
        };
    }



    public static void administerQuiz() {
        ANSWER = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            int qn = 1;
            for (int i = 0; i < 10; i++) {
                System.out.printf("Q %d : %s", qn, questions[i].getQuestion());
                qn++;
                ANSWER[i] = sc.nextInt();
            }
        }
    }

}
