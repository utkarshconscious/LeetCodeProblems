package com.arrays;

public class LargestNumberAtleastTwice {



    public int dominantIndex(int[] nums) {

        if (nums.length==0)
            return -1;
        int largest=0;
        int largestIndex=0;
        int secondLargest=0;

        for (int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                secondLargest=largest;
                largest=nums[i];
                largestIndex=i;

            }
            else if (nums[i]>secondLargest) {
                secondLargest = nums[i];
            }
        }

        if (largest>=(2*secondLargest))
            return largestIndex;
        else
            return -1;
    }

    public static void main(String [] args){
        int [] nums = {1, 2, 3, 4};
        System.out.println(new LargestNumberAtleastTwice().dominantIndex(nums));
    }
}
