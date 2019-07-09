package com.TwoDArrays;


import java.util.*;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int [] output = new int[matrix.length*matrix[0].length];
        int n=matrix.length;
        int m = matrix[0].length;
        int totalElements = matrix.length*matrix[0].length;
        System.out.println(totalElements);
        int k=0,i=0,j=0;
        boolean upflag=true;
        while (k<totalElements){
           // System.out.println("k is: "+k);
            if (upflag){
                for(;i>=0 && j<m&& k<totalElements;i--,j++){
                    System.out.println("up: "+"i=: "+i + " j=: "+j+ " k=: "+k);
                    output[k]=matrix[i][j];
                    k++;
                }
                if(i<0 && j<m) {i=0;}
                if(j==m) {i=i+2; j--;}
            }
            else{
                System.out.println("down: "+"i=: "+i + " j=: "+j+ " k=: "+k);
                for(;j>=0 && i<n&& k<totalElements;j--,i++){
                    output[k]=matrix[i][j];
                    k++;
                }
                if(j<0 && i<n){ j=0;}
                if(i==n){j=j+2; i--;}

            }
            upflag=!upflag;
        }
        return output;
    }

    public static void main(String [] args){
        int [][] nums = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        /* int [][] nums = {{2,3}};*/

        System.out.println(Arrays.toString(new DiagonalTraverse().findDiagonalOrder(nums)));
    }


}
