package Ex_02;

import java.util.Arrays;

public class Main {

    public static final int MATRIX_SIZE = 8;

    public static void main(String[] args) {
        int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

        initRandomMatrix(matrix);

        System.out.println("전치 전 행렬");

        printSquareArray(matrix);

        System.out.println("전치 후 행렬");

        transposeMatrix(matrix);
    }

    public static void initRandomMatrix(int[][] array){
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                array[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static void printSquareArray(int[][] array) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void transposeMatrix(int[][] array) {
        int[][] transposedMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                transposedMatrix[j][i] = array[i][j];
            }
        }
        printSquareArray(transposedMatrix);
    }
}
