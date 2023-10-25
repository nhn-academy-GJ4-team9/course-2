package com.example.chapter7;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Ex7_3 {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long compTime;
        double seconds;
        System.out.println("*Arrays sort double*");
        System.out.println();
        startTime = System.nanoTime();

        double[] doubleArray = new double[100000];
        for(double doubles : doubleArray){
            doubles = Math.random() * 123456789;
        }
        Arrays.sort(doubleArray);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);
        System.out.println("---------------------------------");

        System.out.println();
        System.out.println("*Selection sort double*");
        System.out.println();
        startTime = System.nanoTime();
        double[] doubleArray2 = new double[100000];
        for(double doubles : doubleArray2){
            doubles = Math.random() * 123456789;
        }
        selectionSort(doubleArray2);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("*Arrays sort string*");
        startTime = System.nanoTime();
        String[] strings = new String[100000];
        for(int i = 0; i< strings.length;i++){
            strings[i] = randomStringGenerator();
        }
        Arrays.sort(strings);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;
        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);
        System.out.println("---------------------------------");

        System.out.println();
        System.out.println("*Selection sort string*");
        System.out.println();
        startTime = System.nanoTime();
        String[] strings2 = new String[100000];
        for(int i = 0 ; i< strings2.length;i++){
            strings2[i] = randomStringGenerator();
        }
        selectionSort(strings2);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;
        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);
        System.out.println("---------------------------------");




    }
    static void selectionSort(int[] A) {

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    maxLoc = j;
                }
            }

            int temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }

    }
    static void selectionSort(double[] A) {

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    maxLoc = j;
                }
            }

            double temp = A[maxLoc];

            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }

    }
    static void selectionSort(String[] A){
        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j].compareTo( A[maxLoc])>0) {
                    maxLoc = j;
                }
            }

            String temp = A[maxLoc];

            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }
    }
    public static String randomStringGenerator() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
