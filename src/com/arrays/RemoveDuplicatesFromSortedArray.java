package com.arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < nums.length && nums[i] != nums[prev]) {
                nums[k] = nums[i];
                k++;
                prev = i;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2, 2, 4, 5,5, 6};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        for (int value : nums) {
            System.out.print(value);
        }
        System.out.println();
    }
}
