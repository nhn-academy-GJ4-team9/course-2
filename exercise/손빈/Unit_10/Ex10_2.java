package org.example;

import java.util.Arrays;

public class Ex10_2 {
    public static int[] union(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        int resultIndex = a.length;
        for (int value : b) {
            if (!contains(result, resultIndex, value)) {
                result[resultIndex] = value;
                resultIndex++;
            }
        }
        return Arrays.copyOf(result, resultIndex);
    }

    public static int[] intersection(int[] a, int[] b) {
        int[] result = new int[Math.min(a.length, b.length)];
        int resultIndex = 0;
        for (int value : a) {
            if (contains(b, b.length, value) && !contains(result, resultIndex, value)) {
                result[resultIndex] = value;
                resultIndex++;
            }
        }
        return Arrays.copyOf(result, resultIndex);
    }

    public static int[] difference(int[] a, int[] b) {
        int[] result = new int[a.length];
        int resultIndex = 0;
        for (int value : a) {
            if (!contains(b, b.length, value)) {
                result[resultIndex] = value;
                resultIndex++;
            }
        }
        return Arrays.copyOf(result, resultIndex);
    }

    public static boolean contains(int[] array, int length, int value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {3, 5, 7};

        int[] unionResult = union(a, b);
        int[] intersectionResult = intersection(a, b);
        int[] differenceResult = difference(a, b);

        System.out.println("Union: " + Arrays.toString(unionResult));
        System.out.println("Intersection: " + Arrays.toString(intersectionResult));
        System.out.println("Difference: " + Arrays.toString(differenceResult));
    }
}
