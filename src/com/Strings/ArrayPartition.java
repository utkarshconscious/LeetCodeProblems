package com.Strings;

import java.util.Arrays;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {

        if(nums.length<2)
            return 0;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0,j=1;j<nums.length;i+=2,j+=2){
            sum=Math.min(nums[i],nums[j])+sum;
        }
        return sum;
    }

    public static void main (String [] args){
        int [] nums = {1,4,3,2};
        System.out.println(new ArrayPartition().arrayPairSum(nums));
    }


}
