package Ex_03;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int ARRAY_LENGTH = 10000;

    public static void main(String[] args) {

        int[] intArr = initRandomIntArray();

        String[] strArr = initRandomStrArray();

        timeCheckingIntArray(intArr);

        timeCheckingStrArray(strArr);
    }

    public static int[] initRandomIntArray() {
        int[] intArr = new int[ARRAY_LENGTH];
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            intArr[i] = random.nextInt(100);
        }
        return intArr;
    }

    public static String[] initRandomStrArray() {
        String[] strArr = new String[ARRAY_LENGTH];
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            int length = random.nextInt(10) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                sb.append(randomChar);
            }
            strArr[i] = sb.toString();
        }
        return strArr;
    }

    public static void timeCheckingIntArray(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();
        selectionSort(copyArray);
        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        System.out.println("정수 배열 선택 정렬 시간: " + resultTime);

        copyArray = Arrays.copyOf(array, array.length);

        startTime = System.nanoTime();
        Arrays.sort(copyArray);
        endTime = System.nanoTime();
        resultTime = endTime - startTime;
        System.out.println("정수 배열 Arrays.sort 시간: " + resultTime);
    }

    public static void timeCheckingStrArray(String[] array) {
        String[] copyArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();
        selectionSort(copyArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("문자열 배열 선택 정렬 시간 : " + duration);

        copyArray = Arrays.copyOf(array, array.length);

        startTime = System.nanoTime();
        Arrays.sort(copyArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("문자열 배열 Arrays.sort 시간 : " + duration);
    }

    static void selectionSort(int[] arr) {
        for (int lastPlace = arr.length - 1; lastPlace > 0; lastPlace--) {
            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (arr[j] > arr[maxLoc]) {
                    maxLoc = j;
                }
            }
            int temp = arr[maxLoc];
            arr[maxLoc] = arr[lastPlace];
            arr[lastPlace] = temp;
        }
    }

    static void selectionSort(String[] arr) {
        for (int lastPlace = arr.length - 1; lastPlace > 0; lastPlace--) {
            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (arr[j].compareTo(arr[maxLoc]) > 0) {
                    maxLoc = j;
                }
            }
            String temp = arr[maxLoc];
            arr[maxLoc] = arr[lastPlace];
            arr[lastPlace] = temp;
        }
    }
}
