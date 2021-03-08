package com.arrays;

import java.util.*;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        for (int k = j; k >= 0; k--) {
            int sq;
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                sq = nums[j] * nums[j];
                j--;
            } else {
                sq = nums[i] * nums[i];
                i++;
            }
            res[k] = sq;
        }
        return res;
    }
}
