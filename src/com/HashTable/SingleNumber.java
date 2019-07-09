package com.HashTable;

import java.util.*;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                continue;
            }
            map.put(nums[i],1);
        }

        for (Map.Entry<Integer,Integer> enn: map.entrySet()){
            if(enn.getValue()==1)
                return enn.getKey();
        }
        return -1;
    }
    public static void main (String [] args){

        int [] nums = {1,2,2,3,1};
        System.out.println(new SingleNumber().singleNumberXOR(nums,nums.length));
    }
    int singleNumberXOR(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
            System.out.println(result);
        }
        return result;
    }
}
