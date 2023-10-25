package Ex_05;

import java.util.Scanner;

public class Main {

    public static final int MAX_SIZE_ARRAY = 100;

    public static void main(String[] args) {

        double[] arr = new double[MAX_SIZE_ARRAY];

        initArr(arr);

        printArray(arr);

        insertionSort(arr);

        printArray(arr);

    }

    public static void initArr(double[] arr) {
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < MAX_SIZE_ARRAY; i++) {
                double input = scanner.nextDouble();
                if (input == 0) {
                    break;
                }
                arr[i] = input;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertionSort(double[] arr) {
        for (int i = 1; i < MAX_SIZE_ARRAY; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < MAX_SIZE_ARRAY; i++) {
            if (arr[i] == 0.0) {
                continue;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
