package com.example.chapter7;

import java.util.Arrays;

public class Ex7_2 {
    public static void main(String[] args) {
        System.out.println("make transpose array");
        int[][] ints =  {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[][] ints1 = {{1,2,3},{1,2,3},{1,2,3}};

        System.out.println("ori");
        printArray(ints);
        System.out.println("trans");
        printArray(transpose(ints));
        System.out.println("again");
        printArray(transpose(transpose(ints)));
        System.out.println("ori");
        printArray(ints1);
        System.out.println("trans");
        printArray(transpose(ints1));
        System.out.println("again");
        printArray(transpose(transpose(ints1)));
    }

    public static int[][] transpose(int[][] myArray) {
        int row = myArray.length;
        int col = myArray[0].length;
        int[][] transpose = new int[row][col];
        for(int i = 0 ; i< row; i++){
            for(int j = 0 ; j<col;j++){
                int tmp =  myArray[j][i];
                transpose[i][j] = tmp;
            }
        }

        return transpose;
    }

    public static void printArray(int[][] myArray) {
        for(int[] arrays : myArray){
            System.out.println(Arrays.toString(arrays));
        }
    }

}
