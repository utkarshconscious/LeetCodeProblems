package com.Queue;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquare {

    public int numSquares(int n) {

        List<Integer> squares = new ArrayList<Integer>();

        if(n<2){
            return n;
        }
        int i = 0;
        while (i * i <= n) {
            squares.add(i * i);
            i++;
        }
        System.out.println(squares.get(6));
        int sum=0;
        int count=0;
        int minCount=n;
        for(int k=squares.size()-1;k>0;k--) {
            count=0;
            i=k;
            sum=0;
            while (sum != n) {
                if (sum + squares.get(i) <= n) {
                    sum = sum + squares.get(i);
                    count++;
                } else {
                    i--;
                }
            }
            if(minCount>count)
                minCount=count;
        }

        return minCount;
    }

    public static void main(String [] args){
        System.out.println(new PerfectSquare().numSquares(43));
    }
}
