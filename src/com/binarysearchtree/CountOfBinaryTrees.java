package com.binarysearchtree;

import java.util.*;
// Uses Dynamic Programming
public class CountOfBinaryTrees {

    public static int numberOfBST(int n){

        if(n<=1)
            return 1;
        int[] N = new int[n];

        N[0]=1;
        N[1]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                N[i]+=N[j]*N[i-j-1];
            }
        }

        return N[n-1];
    }

public static void main(String [] args){

        while(true) {
            System.out.print("Enter the Number: ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            System.out.println("i is: "+i);
            if(i==0)
                System.exit(0);
            System.out.println(numberOfBST(i));
            System.out.println();
        }
}

}
