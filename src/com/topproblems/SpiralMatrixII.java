package com.topproblems;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int low = 0;
        int high = n - 1;
        int count = 0;
        while (low <= high) {
            for (int i = low; i <= high; i++) {
                matrix[low][i] = ++count;
            }
            for (int i = low + 1; i < high; i++) {
                matrix[i][high] = ++count;
            }
            for (int i = high; i > low; i--) {
                matrix[high][i] = ++count;
            }
            for (int i = high; i > low; i--) {
                matrix[i][low] = ++count;
            }
            high--;
            low++;
        }
        return matrix;
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int[] row : mat) {

            // Loop through all columns of current row
            for (int x : row) {
                System.out.print(x + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        generateMatrix(5);
    }
}
