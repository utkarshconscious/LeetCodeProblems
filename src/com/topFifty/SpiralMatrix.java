package com.topFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            Collections.emptyList();
        }
        List<Integer> output = new ArrayList<>();
        int colMin = 0;
        int colMax = matrix[0].length - 1;
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int totalElements = matrix.length * matrix[0].length;

        for (int i = 0; i < totalElements; ) {

            for (int col = colMin; col <= colMax && i < totalElements; col++) {
                output.add(matrix[rowMin][col]);
                i++;

            }
            for (int row = rowMin + 1; row < rowMax && i < totalElements; row++) {
                output.add(matrix[row][colMax]);
                i++;
            }
            for (int col = colMax; col > colMin && i < totalElements; col--) {
                output.add(matrix[rowMax][col]);
                i++;
            }
            for (int row = rowMax; row > rowMin && i < totalElements; row--) {
                output.add(matrix[row][colMin]);
                i++;
            }
            colMin++;
            colMax--;
            rowMin++;
            rowMax--;
        }


        return output;
    }

    public static void main(String[] args) {
        int[][] input =  {{1},{3},{5},{7}};
        System.out.print(spiralOrder(input));

    }
}

