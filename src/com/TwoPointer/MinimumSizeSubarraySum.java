package com.TwoPointer;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int len = 0;
        int sum = 0;
        int minlen = nums.length + 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum >= s) {
                while (sum-nums[j] >= s) {
                    sum=sum-nums[j];
                    j++;
                }
                if(minlen>i-j+1)
                    minlen=i-j+1;

                sum=sum-nums[j];
                j++;
            }
        }
        if (minlen == nums.length + 1)
            return 0;
        else
            return minlen;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(11, nums));
    }
}
