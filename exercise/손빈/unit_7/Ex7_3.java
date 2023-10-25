package org.example;
import java.util.Arrays;

public class Ex7_3 {
    final static int SIZE = 100000;

    private static double[] randomNumbers(int count) {
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++)
            numbers[i] = Math.random();
        return numbers;
    }

    private static void selectionSort(double[] numbers) {
        for (int top = numbers.length-1; top > 0; top-- ) {
            int maxloc = 0;
            for (int i = 1; i <= top; i++) {
                if (numbers[i] > numbers[maxloc])
                    maxloc = i;
            }
            double temp = numbers[top];
            numbers[top] = numbers[maxloc];
            numbers[maxloc] = temp;
        }
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        double[] numberList1;
        double[] numberList2;

        numberList1 = randomNumbers(10);
        selectionSort(numberList1);
        for (double n : numberList1)
            System.out.println( "   " + n );

        System.out.println(SIZE + " 크기의 배열을 정렬하는 데 걸린 시간:");

        numberList1 = randomNumbers(SIZE);
        numberList2 = Arrays.copyOf(numberList1, SIZE);

        startTime = System.nanoTime();
        selectionSort(numberList1);
        endTime = System.nanoTime();
        System.out.printf("selectionSort로 %d개의 숫자를 정렬하는 데 걸린 시간: %1.6g 초%n",
                SIZE, (endTime - startTime) / 1e9);

        startTime = System.nanoTime();
        Arrays.sort(numberList2);
        endTime = System.nanoTime();
        System.out.printf("Arrays.sort()로 %d개의 숫자를 정렬하는 데 걸린 시간: %1.6g 초%n",
                SIZE, (endTime - startTime) / 1e9);

    }
}
