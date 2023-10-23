import java.util.Scanner;

/**
 * Problem
 * 주사위 한쌍을 굴려 원하는 숫자(2~12)가 나올때까지 몇번 굴려야 하는지 출력
 * IllegalArgumentException 예외 처리 사용
 */
public class Ex_03 {

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in)) {
            int findValue = scanner.nextInt();
            isfindValue(findValue);
            System.out.println(findValue + "이(가) 나올때 까지 총 돌린 횟수 : " + roll(findValue));
        }
    }

    public static void isfindValue(int findValue) {
        if (findValue > 12 || findValue < 2) {
            throw new IllegalArgumentException("올바르지 않은 값입니다.");
        }
    }

    public static int roll(int findValue) {
        int[] diceArr = new int[2];
        int count = 0;
        while (true) {
            int sumDices = 0;
            count++;
            for (int i = 0; i < diceArr.length; i++) {
                diceArr[i] = (int) (Math.random() * 6) + 1;
                sumDices += diceArr[i];
            }
            if (isMatchValue(sumDices, findValue)) {
                break;
            }
        }
        return count;
    }

    public static boolean isMatchValue(int sumDice, int findValue) {
        if (sumDice == findValue) {
            return true;
        } else {
            return false;
        }
    }
}
