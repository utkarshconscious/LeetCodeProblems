package com.topproblems;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {

            currMax = nums[i] > currMax + nums[i] ? nums[i] : currMax + nums[i];
            max = Math.max(currMax, max);

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

}
