package com.topFifty;

//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
public class JumpGame {

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int max = 0;
        int index = 0;

        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i] == 0) {
                return false;
            }
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j + nums[j] >= nums.length - 1) {
                    return true;
                }
                if (j + nums[j] > max) {
                    max = j + nums[j];
                    index = j;
                }
            }
            i = index;
            max = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};

        System.out.println(canJump(nums));
    }
}
