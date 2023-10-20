import java.util.Random;

public class Ex_07_1 {
    public static void main(String[] args) {
        int[] numArr = new int[365];
        int count = findThreePeople(numArr);
        System.out.println(count);
    }

    public static int findThreePeople(int[] numArr) {
        int count = 0;
        Random random = new Random();
        while (true) {
            int birthday = random.nextInt(365) + 1;
            count++;
            if (numArr[birthday] == 2) {
                break;
            }
            numArr[birthday]++;
        }
        return count;
    }
}
