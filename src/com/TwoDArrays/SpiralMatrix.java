package com.TwoDArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length==0)
            return  new ArrayList<Integer>(0);
        int totalElement = matrix.length*matrix[0].length;
        int m= matrix.length;
        int n=matrix[0].length;
        int k=0;
        int count=0;
        System.out.println(m+" "+n);
        List<Integer> output = new ArrayList<Integer>();
        while (count<totalElement){

            for(int i=k;i<=n-k-1;i++){
                output.add(matrix[k][i]);
                count++;
            }
            System.out.println("1: "+output);
            for(int j=k+1;j<m-k;j++){
                output.add(matrix[j][n-k-1]);
                count++;
            }
            System.out.println("2: "+output);
            for(int i=n-k-2;i>=k&&i<m-k;i--){
                output.add(matrix[m-k-1][i]);
                count++;
            }
            System.out.println("3: "+output);
            for(int j=m-k-2;j>k;j--){
                //System.out.println(j+" "+k+" "+count);
                output.add(matrix[j][k]);
                count++;
            }
            System.out.println("4: "+output);
            if(k==1)
            System.exit(0);
            k++;
        }
        return output;
    }

    public  static void main(String [] args){
         /* int [][] nums = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};*/
        int [][] nums = {{2,3}};

        System.out.println((new SpiralMatrix().spiralOrder(nums)));
    }
}
