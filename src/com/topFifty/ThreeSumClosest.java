package com.topFifty;

import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

public class ThreeSumClosest {
    // [-1,2,1,-4] [-4,-1,1,2]
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer output = null;
        for (int i = 0; i < nums.length - 2; i++) {
            int high = nums.length - 1, low = i + 1;
            while (high > low) {
                int currDiff = Math.abs(target - (nums[i] + (nums[low] + nums[high])));
                if(output == null){
                    output = nums[i] + nums[low] + nums[high];
                }else {
                    output = currDiff > Math.abs(target - output) ? output : nums[i] + (nums[low] + nums[high]);
                }
                if (nums[i] + nums[low] + nums[high] > target) {
                    high--;

                } else if (nums[i] + nums[low] + nums[high] == target) {
                    output = target;
                    break;
                } else {
                    low++;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums,-1));
    }
}
