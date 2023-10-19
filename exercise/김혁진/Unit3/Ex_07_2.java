import java.util.Random;

public class Ex_07_2 {
    public static void main(String[] args) {
        int[] numArr = new int[365];
        int count = findDifferentBirthdays(numArr);
        System.out.println(count);
    }

    public static int findDifferentBirthdays(int[] numArr) {
        boolean[] usedDates = new boolean[365];
        Random random = new Random();

        for (int i = 0; i < 365; i++) {
            int birthday = random.nextInt(365);
            usedDates[birthday] = true;
        }

        int count = countUsedDays(usedDates);
        return count;
    }

    public static int countUsedDays(boolean[] used) {
        int count = 0;
        for (boolean isUsed : used) {
            if (isUsed) {
                count++;
            }
        }
        return count;
    }
}
