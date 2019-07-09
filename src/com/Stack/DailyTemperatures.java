package com.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
   /* public int[] dailyTemperatures(int[] T) {
        if(T.length==0){
            int [] i = {0};
            return i;
        }
        int [] output = new int[T.length];
        for(int i=0;i<T.length-1;i++){
            int j=i+1;
            int count=0;
            while(j<T.length&&T[j]<=T[i]){
                count++;
                j++;
            }
            if(j==T.length)
                output[i]=0;
            else{
                output[i]=count+1;
            }
        }
        return output;
    }*/


    /*public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }
    public int[] dailyTemperatures(int[] T) {
        //stack[] stores days waiting for a warmer day
        //res[]stores return result
        //top counts the stack index and hold the current last element
        int[] res = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;

        for(int i = 0; i < T.length; i++) {
            while(top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return res;
    }
    */

    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int [] output = new int[T.length];
        for( int i = T.length-1;i>=0;i--){

            while (!stack.isEmpty()&&T[i]>=T[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                output[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return output;
    }
    public static void main(String [] args){
       // int [] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int [] T = {73,73, 74};
        int [] output =new DailyTemperatures().dailyTemperatures(T);
        for (int i: output){
            System.out.print(i+" ");
        }
    }
}
