package org.example;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {


        int[] notSortedArr = makeRandomArr(100000);
        int[] notSortedArr2 = Arrays.copyOf(notSortedArr, 100000);

        System.out.print("Arrays.sort()을 이용하여 정렬할 때 걸리는 시간:    ");
        arrSort(notSortedArr);
        System.out.print("선택정렬을 이용하여 정렬할 때 걸리는 시간:   ");
        arrSelectionSort(notSortedArr2);

        System.out.println();

        String[] notSortedStr = makeRandomStr(100000);
        String[] notSortedStr2 = Arrays.copyOf(notSortedStr,100000);

        System.out.print("Arrays.sort()을 이용하여 정렬할 때 걸리는 시간:    ");
        strSort(notSortedStr);
        System.out.print("선택정렬을 이용하여 정렬할 때 걸리는 시간:   ");
        strSelectionSort(notSortedStr2);

    }


    /**
     * 랜덤한 알파벳요소를 가지는 배열을 만드는 메서드
     * @param i
     * @return
     */
    private static String[] makeRandomStr(int i) {
        String[] str = new String[i];
        int random = (int)(Math.random()*25)+97;
        for (int j = 0; j < i; j++) {
            str[j]=String.valueOf((char)random);
        }
        return str;
    }


    /**
     * 랜덤한 요소를 가지는 배열을 만드는 메서드
     * @param i
     * @return
     */

    private static int[] makeRandomArr(int i) {
        int[] arr = new int[i];
        for (int j = 0; j < i; j++) {
            arr[j] = (int) (Math.random() * i);
        }
        return arr;
    }


    /**
     * Arrays.sort()을 이용하여 배열을 정렬하는 메서드
     * @param notSortedArr
     */
    private static void arrSort(int[] notSortedArr) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.


        startTime = System.nanoTime();

        Arrays.sort(notSortedArr);

        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9);


    }


    /**
     * Arrays.sort()을 이용하여 문자열을 정렬하는 메서드
     * @param notSortStr
     */
    private static void strSort(String[] notSortStr){
        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.


        startTime = System.nanoTime();

        Arrays.sort(notSortStr);

        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9);
    }


    /**
     * 선택정렬을 이용하여 배열을 정렬하는 메서드
     * @param notSortedArr
     */
    private static void arrSelectionSort(int[] notSortedArr) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.
        startTime = System.nanoTime();


        for (int i = 0; i < notSortedArr.length; i++) {

            int min = notSortedArr[i];
            int index = i;

            for (int j = i; j < notSortedArr.length; j++) {
                if (notSortedArr[j] < min) {
                    min = notSortedArr[j];
                    index = j;
                }
            }

            int temp = notSortedArr[index];
            notSortedArr[index] = notSortedArr[i];
            notSortedArr[i] = temp;

        }


        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9);
    }


    /**
     * 선택정렬을 이용해서 문자열 정렬하는 메서드
     * @param notSortedArr
     */
    private static void strSelectionSort(String[] notSortedArr) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.
        startTime = System.nanoTime();


        for (int i = 0; i < notSortedArr.length; i++) {

            int min = notSortedArr[i].charAt(0);
            int index = i;

            for (int j = i; j < notSortedArr.length; j++) {
                if (notSortedArr[j].charAt(0) < min) {
                    min = notSortedArr[j].charAt(0);
                    index = j;
                }
            }

            int temp = notSortedArr[index].charAt(0);
            notSortedArr[index] = notSortedArr[i];
            notSortedArr[i]= String.valueOf((char)temp);

        }


        endTime = System.nanoTime();


        System.out.println((endTime - startTime) / 1e9);
    }


}
