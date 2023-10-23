package org.example;

public class Ex4_5 {

    public static ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value)
                    count++;
            }
            return count;
        };
    }

    public static final ArrayProcessor maxer = array -> {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    };

    public static final ArrayProcessor miner = array -> {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    };

    public static final ArrayProcessor sumer = array -> {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    };

    public static final ArrayProcessor averager = array -> sumer.apply(array) / array.length;

    public static void main(String[] args) {

        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };

        System.out.println("첫 번째 리스트의 합 (55여야 함): " + sumer.apply(firstList));
        System.out.println("첫 번째 리스트의 평균 (5.5여야 함): " + averager.apply(firstList));
        System.out.println("두 번째 리스트의 최솟값 (-3.4여야 함): " + miner.apply(secondList));
        System.out.println("두 번째 리스트의 최댓값 (42.0여야 함): " + maxer.apply(secondList));

        System.out.println();

        System.out.println("두 번째 리스트에서 17.0의 개수 (3이어야 함): " + counter(17.0).apply(secondList));
        System.out.println("두 번째 리스트에서 20.0의 개수 (0이어야 함): " + counter(20.0).apply(secondList));
        System.out.println("첫 번째 리스트에서 5.0의 개수 (1이어야 함): " + counter(5.0).apply(firstList));

    }
}
