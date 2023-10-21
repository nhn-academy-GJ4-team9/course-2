package org.example;

public class Ex5 {

    /**
     * 배열값을 받아서 배열 안에 있는 모든 값을 더하고 그 값을 리턴하는 static 변수
     */
    private static ArrayProcessor sumer = array -> {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum;
    };

    public static void main(String[] args) {
        double[] firstList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] secondList = {17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14};

        System.out.println("Sum of first list (should be 55): "
                + sumer.apply(firstList));
        System.out.println("Average of first list (should be 5.5): "
                + averager().apply(firstList));
        System.out.println("Minimum of second list (should be -3.4): "
                + miner().apply(secondList));

        System.out.println("Maximum of second list (should be 42.0): "
                + maxer().apply(secondList));

        System.out.println("Count of 17.0 in second list (should be 3): "
                + counter(17.0).apply(secondList));
        System.out.println("Count of 20.0 in second list (should be 0): "
                + counter(20.0).apply(secondList));
        System.out.println("Count of 5.0 in first list (should be 1): "
                + counter(5.0).apply(firstList));
    }

    /**
     * 배열의 최솟값을 리턴하는 메소드
     *
     * @return
     */
    private static ArrayProcessor miner() {
        return new ArrayProcessor() {
            @Override
            public double apply(double[] array) {
                double min = 0;
                for (double d : array) {
                    if (min > d) {
                        min = d;
                    }
                }
                return min;
            }
        };
    }

    /**
     * 배열에 있는 값의 평균을 알려주는 메소드
     *
     * @return
     */
    private static ArrayProcessor averager() {
        return new ArrayProcessor() {
            @Override
            public double apply(double[] array) {
                double sum = 0;
                for (double d : array) {
                    sum += d;
                }
                return sum / array.length;
            }
        };
    }


    /**
     * 배열에 input값의 개수를 세주는 함수
     *
     * @param input
     * @return
     */
    private static ArrayProcessor counter(double input) {
        return new ArrayProcessor() {
            @Override
            public double apply(double[] array) {
                int count = 0;
                for (double d : array) {
                    if (d == input) {
                        count++;
                    }
                }
                return count;
            }
        };
    }

    /**
     * 배열에 있는 값중 가장 큰 값을 리턴하는 함수
     *
     * @return
     */

    private static ArrayProcessor maxer() {
        return array -> {
            double max = 0;
            for (double d : array) {
                if (max < d) {
                    max = d;
                }
            }
            return max;
        };
    }
}
