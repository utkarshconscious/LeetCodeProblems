package com.TwoPointer;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,counter=0;

        for (int i=0;i<nums.length;i++){
            if(nums[i]==1)
                counter++;
            else{
                if(counter>max)
                    max=counter; counter=0;
            }
        }
        return counter>max?counter:max;

    }

    public static void main(String [] args){
        int [] nums = {1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }
}
