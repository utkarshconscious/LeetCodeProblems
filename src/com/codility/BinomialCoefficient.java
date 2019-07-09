package com.codility;

public class BinomialCoefficient {

    public int solution(int N, int K) {
        // write your code in Java SE 8
        if(N==0)
            return 0;
        long output=1;
        if(N-K>K)
         output = factorial(N,N-K)/factorial(K,0);
        else
            output = factorial(N,K)/factorial(N-K,0);

        if(output>1000000000)
            return -1;
        return (int)output;

    }

    public static long factorial(int N,int K){
        if(N<=1)
            return 1;
        long output=1;
        while(N>K){
        output=output*N;
        N--;
        }
        return output;
    }
    public static void main(String [] args){
        System.out.println(new BinomialCoefficient().solution(10,10));

    }
}
