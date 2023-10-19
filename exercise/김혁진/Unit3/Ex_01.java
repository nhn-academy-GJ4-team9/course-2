import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem
 * 주사위 n 개가 주어졌을때 주사위 눈이 모두 1이 나왔을 경우를 출력하고
 * 1이 나올때 까지 총 횟수 출력
 */
public class Ex_01 {

    public static void main(String[] args) {

        System.out.print("주사위 개수 입력 : ");
        try (Scanner scanner = new Scanner(System.in)) {
            int diceNum = scanner.nextInt();
            int result = countRolls(diceNum);
            System.out.println("1이 나올 때까지 총 횟수 : " + result);
        }
    }

    /**
     * 모든 값이 1이 나올때까지 주사위를 굴리는 메서드
     *
     * @param diceNum 던질 주사위의 갯수
     * @return 모든 눈이 1이 나올때까지 총 던진 횟수
     */
    public static int countRolls(int diceNum) {
        int[] diceValue = new int[diceNum];
        int count = 0;

        while (true) {
            count++;
            for (int i = 0; i < diceNum; i++) {
                diceValue[i] = (int) (Math.random() * 6) + 1;
            }
            System.out.println("주사위 눈 : " + Arrays.toString(diceValue));

            boolean allOnes = true;
            for (int i = 0; i < diceNum; i++) {
                if (diceValue[i] != 1) {
                    allOnes = false;
                    break;
                }
            }

            if (allOnes) {
                return count;
            }
        }
    }
}
