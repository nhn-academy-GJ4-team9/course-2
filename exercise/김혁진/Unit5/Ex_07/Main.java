package Ex_07;

import java.util.Scanner;

public class Main {

    private static IntQuestion[] quizArr;
    private static int[] answerArr;

    public static void main(String[] args) {
        makeQuiz();
        manageQuiz();
        gradeQuiz();
    }

    private static void makeQuiz() {
        quizArr = new IntQuestion[10];
        for (int i = 0; i < 7; i++) {
            if ((int) (Math.random() * 2) == 1) {
                quizArr[i] = new AdditionQuestion();
            } else {
                quizArr[i] = new SubtractionQuestion();
            }
        }
        quizArr[7] = new IntQuestion() {
            public String getQuestion() {
                return "How many states are there in the United States?";
            }

            public int getCorrectAnswer() {
                return 50;
            }
        };
        quizArr[8] = new IntQuestion() {
            public String getQuestion() {
                return "In what year did the First World War begin?";
            }

            public int getCorrectAnswer() {
                return 1914;
            }
        };
        quizArr[9] = new IntQuestion() {
            public String getQuestion() {
                return "What is the answer to the ultimate question " +
                        "of life, the universe, and everything?";
            }

            public int getCorrectAnswer() {
                return 42;
            }
        };
    }

    private static void manageQuiz() {
        answerArr = new int[10];
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                System.out.print("질문 " + (i + 1) + ": ");
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
