package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex7_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("양의 실수를 입력하세요. 0을 입력하면 종료됩니다.");

        ArrayList<Double> numbers = new ArrayList<>();

        double input = scanner.nextDouble();
        while (input != 0) {
            numbers.add(input);
            input = scanner.nextDouble();
        }
        sort(numbers);

        System.out.println("입력된 숫자를 정렬한 결과:");
        for (double number : numbers) {
            System.out.println(number);
        }
    }

    public static void sort(ArrayList<Double> arr) {
        int n = arr.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr.get(i - 1) > arr.get(i)) {
                    double temp = arr.get(i - 1);
                    arr.set(i - 1, arr.get(i));
                    arr.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
