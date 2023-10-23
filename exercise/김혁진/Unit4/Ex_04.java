import java.util.Arrays;

/**
 * Problem
 * 주사위를 10000번 던졌을때 평균 굴린 횟수를 출력하기
 */
public class Ex_04 {
    public static void main(String[] args) {
        int[] rollResultValues = new int[13];
        roll(rollResultValues);
        System.out.println(Arrays.toString(rollResultValues));
        System.out.println("주사위 합 \t 평균값");
        for (int i = 2; i <= 12; i++) {
            double avg = Math.round(((10000 / rollResultValues[i]) * 100) / 100.0);

            System.out.println("\t" + i + "\t\t " + avg);
        }
    }

    public static int[] roll(int[] rollResultValues) {
        int[] diceArr = new int[2];
        for (int i = 0; i < 10000; i++) {
            int sumDices = 0;
            for (int j = 0; j < diceArr.length; j++) {
                diceArr[j] = (int) (Math.random() * 6) + 1;
                sumDices += diceArr[j];
            }
            rollResultValues[sumDices]++;
        }
        return rollResultValues;
    }
}
