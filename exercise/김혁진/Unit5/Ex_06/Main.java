package Ex_06;

import java.util.Scanner;

public class Main {

    private static AdditionQuestion[] quizArr;
    private static int[] answerArr;

    public static void main(String[] args) {
        makeQuiz();
        manageQuiz();
        gradeQuiz();
    }

    private static void makeQuiz() {
        quizArr = new AdditionQuestion[10];
        for ( int i = 0; i < 10; i++ ) {
            quizArr[i] = new AdditionQuestion();
        }
    }

    private static void manageQuiz() {
        answerArr = new int[10];
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                System.out.print("질문 " + (i+1) + ": ");
                System.out.print(quizArr[i].getQuestion());
                answerArr[i] = scanner.nextInt();
            }
        }
    }

    private static void gradeQuiz() {
        int score = 0;

        for (int i = 0; i < 10; i++) {

            if (answerArr[i] == quizArr[i].getCorrectAnswer()) {
                System.out.println(" (정답)");
                score += 10;
            } else {
                System.out.println(" (오답, 정답은 " + quizArr[i].getCorrectAnswer() + " 입니다)");
            }
        }

        System.out.println("총 점수: " + score + "점");
    }
}
