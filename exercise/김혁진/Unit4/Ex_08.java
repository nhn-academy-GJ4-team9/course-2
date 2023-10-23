import java.util.Scanner;

/**
 * Problem
 * 사용자에게 10개의 덧셈 문제를 물어보고 채점해서 점수 반환.
 */
public class Ex_08 {

    /**
     * 테스트
     * 메서드 퀴즈만들기,관리,채점
     *
     * @param args 커맨드 라인 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        int[] firstNums = new int[10];
        int[] secondNums = new int[10];
        int[] answers = new int[10];
        makeQuiz(firstNums, secondNums);
        manageQuiz(firstNums, secondNums, answers);
        gradeQuiz(firstNums, secondNums, answers);
    }

    /**
     * 10개의 덧셈 문제를 생성.
     *
     * @param firstNumbers  첫 번째 숫자 배열
     * @param secondNumbers 두 번째 숫자 배열
     */
    private static void makeQuiz(int[] firstNumbers, int[] secondNumbers) {
        for (int i = 0; i < 10; i++) {
            firstNumbers[i] = (int) (Math.random() * 100 + 1);
            secondNumbers[i] = (int) (Math.random() * 100);
        }
    }

    /**
     * 사용자에게 10개의 덧셈 문제를 물어보고 사용자의 답변을 기록합니다.
     *
     * @param firstNums  첫 번째 숫자 배열
     * @param secondNums 두 번째 숫자 배열
     * @param answers    사용자의 답변 배열
     */
    private static void manageQuiz(int[] firstNums, int[] secondNums, int[] answers) {
        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < 10; i++) {
                int questionNumber = i + 1;
                System.out.print("질문 " + questionNumber + ": ");
                System.out.print(firstNums[i] + " + " + secondNums[i] + " = ");
                answers[i] = scanner.nextInt();
            }
        }
    }

    /**
     * 덧셈 문제를 채점하고 결과를 출력
     * ex) 질문 1 : 40 + 30 = 50 (오답, 정답은 ~)
     *
     * @param firstNums  첫 번째 숫자 배열
     * @param secondNums 두 번째 숫자 배열
     * @param answers    사용자의 답변 배열
     */
    private static void gradeQuiz(int[] firstNums, int[] secondNums, int[] answers) {
        int score = 0;

        for (int i = 0; i < 10; i++) {
            int questionNumber = i + 1;
            int expectedAnswer = firstNums[i] + secondNums[i];
            System.out.print("질문 " + questionNumber + ": ");
            System.out.print(firstNums[i] + " + " + secondNums[i] + " = " + answers[i]);

            if (answers[i] == expectedAnswer) {
                System.out.println(" (정답)");
                score += 10;
            } else {
                System.out.println(" (오답, 정답은 " + expectedAnswer + " 입니다)");
            }
        }

        System.out.println("총 점수: " + score + "점");
    }
}
