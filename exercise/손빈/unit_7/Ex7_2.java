package org.example;

public class Ex7_2 {
    private static final int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    public static void main(String[] args) {
        Transposition(matrix);
    }

    public static void Transposition(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println(" ");
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}