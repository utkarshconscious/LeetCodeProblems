package com.topFifty;
//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Your goal is to reach the last index in the minimum number of jumps.
//You can assume that you can always reach the last index.

public class JumpGameII {


    public static int jump(int[] nums) {
        if(nums.length <=1){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; ) {
            int maxJump = 0;
            int index = 0;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j == nums.length - 1) {
                    index = j;
                    break;
                } else if (j + nums[j] > maxJump) {
                    maxJump = j + nums[j];
                    index = j;
                }
            }
            i = index;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};

        System.out.println(jump(nums));
    }
}
