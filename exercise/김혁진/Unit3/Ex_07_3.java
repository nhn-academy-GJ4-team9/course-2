import java.util.Random;

public class Ex_07_3 {
    public static void main(String[] args) {
        int count = findAllBirthdays();
        System.out.println(count);
    }

    public static int findAllBirthdays() {
        boolean[] usedDates = new boolean[365];
        Random random = new Random();

        int count = 0;
        int birthdaysFound = 0;

        while (birthdaysFound < 365) {
            int birthday = random.nextInt(365);
            count++;
            if (!usedDates[birthday]) {
                usedDates[birthday] = true;
                birthdaysFound++;
            }
        }

        return count;
    }
}
