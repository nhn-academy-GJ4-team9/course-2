package org.example;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        int[] answer = new int[10];

        IntQuestion[] intQuestions = new IntQuestion[10];

        try (Scanner scanner = new Scanner(System.in)) {
            answer = makeQuestion(intQuestions, answer);
            replyAnswer(scanner, answer, intQuestions);
        }

    }

    /**
     * 10개의 덧셈+뺼셈 질문을 만드는 메소드
     *
     * @return
     */
    private static int[] makeQuestion(IntQuestion[] intQuestions, int[] answer) {

        for (int i = 0; i < answer.length; i++) {
            if (i % 2 == 0) {
                intQuestions[i] = new AdditionQuestion();
            } else {
                intQuestions[i] = new SubtractionQuestion();
            }

            answer[i] = intQuestions[i].getCorrectAnswer();
        }

        return answer;


    }


    /**
     * 10개의 질문에 대한 정답을 입력하는 메소드
     *
     * @param scanner
     * @param answer
     */

    private static void replyAnswer(Scanner scanner, int[] answer, IntQuestion[] intQuestions) {
        int count = 0;
        int right;
        for (int i = 0; i < answer.length; i++) {
            System.out.print(intQuestions[i].getQuestion());
            right = scanner.nextInt();
            count = score(count, answer, right, i);
        }

        System.out.println("맞힌 개수: " + count);

    }


    /**
     * 내가 입력한 값이 정답인지 아닌지 판별해주는 메소드
     *
     * @param count
     * @param answer
     * @param right
     * @param i
     * @return
     */
    private static int score(int count, int[] answer, int right, int i) {
        if (right == answer[i]) {
            System.out.println("정답입니다.");
            return count + 1;
        } else {
            System.out.println("틀렸습니다.\n정답은 " + answer[i] + " 입니다. ");
            return count;
        }

    }
}




