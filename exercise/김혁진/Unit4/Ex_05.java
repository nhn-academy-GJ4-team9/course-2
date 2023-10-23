/**
 * Problem
 * 함수형 인터페이스 ArrayProcessor를 이용하여
 * 배열을 처리하는 4가지 연산을 람다식으로 처리하는 문제
 */
public class Ex_05 {

    /**
     * 배열에서 최댓값.
     */
    public static final ArrayProcessor max = (array) -> {
        if (array.length == 0) {
            return 0.0;
        }
        double max = array[0];
        for (double value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    };

    /**
     * 배열에서 최솟값.
     */
    public static final ArrayProcessor min = (array) -> {
        if (array.length == 0) {
            return 0.0;
        }
        double min = array[0];
        for (double value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    };

    /**
     * 배열의 합을 계산.
     */
    public static final ArrayProcessor sum = (array) -> {
        double sum = 0.0;
        for (double value : array) {
            sum += value;
        }
        return sum;
    };

    /**
     * 배열의 평균을 계산.
     */
    public static final ArrayProcessor average = (array) -> {
        if (array.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    };

    /**
     * 배열에서 주어진 값의 횟수를 계산.
     *
     * @param value 출현 횟수를 계산할 값
     * @return 배열에서 주어진 값의 출현 횟수
     */
    public static ArrayProcessor counter(double value) {
        return (array) -> {
            int count = 0;
            for (double element : array) {
                if (element == value) {
                    count++;
                }
            }
            return count;
        };
    }

    /**
     * Main
     *
     * @param args 커맨드 라인 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0, 4.0, 3.0};
        System.out.println("최댓값: " + max.apply(array));
        System.out.println("최솟값: " + min.apply(array));
        System.out.println("합계: " + sum.apply(array));
        System.out.println("평균: " + average.apply(array));

        double valueToCount = 3.0;
        ArrayProcessor counter = counter(valueToCount);
        System.out.println(valueToCount + "의 개수: " + counter.apply(array));
    }
}
