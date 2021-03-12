package com.arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 0 && i < nums.length && nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1};
        new MoveZeroes().moveZeroes(nums);
        for (int value : nums) {
            System.out.print(value);
        }
        System.out.println();
    }
}
