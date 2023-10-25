package org.example;

public class Ex2 {
    public static void main(String[] args) {
        int[][] orig = {
                { 1, 2, 3, 4, 5, 6 },
                { 10, 20, 30, 40, 50, 60 },
                { 100, 200, 300, 400, 500, 600 }
        };
        System.out.println("Original matrix:");
        System.out.println();
        print(orig);
        System.out.println();
        System.out.println("The transpose:");
        System.out.println();
        print( computeTranspose(orig) );
        System.out.println();
        System.out.println();

        orig = new int[][] {
                {1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5, 5, 5},
                {6, 6, 6, 6, 6, 6, 6},
                {7, 7, 7, 7, 7, 7, 7},
        };
        System.out.println("Original matrix:");
        System.out.println();
        print(orig);
        System.out.println();
        System.out.println("The transpose:");
        System.out.println();
        print( computeTranspose(orig) );
        System.out.println();

    }

    /**
     * 전치행렬을 만드는 메서드
     * @param orig
     * @return
     */
    private static int[][] computeTranspose(int[][] orig) {

        int length= orig.length;
        int length2=orig[0].length;

        int trans[][] = new int[length2][length]; //6 , 3

        for (int i = 0; i < length2; i++) {
            for (int j = 0; j < length; j++) {
                trans[i][j]=orig[j][i];
            }
        }
        return trans;
    }

    /**
     * 2차원 배열을 출력하는 메서드
     * @param orig
     */
    private static void print(int[][] orig) {

        for (int[] a: orig) {
            for (int b : a ) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}
