package com.topproblems;

public class SortColors {
    public static void sortColors(int[] nums) {
        int countZeros = 0;
        int countOnes = 0;
        int countTotal = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            } else if (nums[i] == 1) {
                countOnes++;
            }
        }
        fillIndexes(0, countZeros, nums, 0);
        fillIndexes(countZeros, countOnes, nums, 1);
        fillIndexes(countOnes + countZeros, countTotal - countZeros - countOnes, nums, 2);

    }

    private static void fillIndexes(int start, int end, int[] nums, int value) {
        int counter = 0;
        int index = start;
        while (counter < end) {
            nums[index++] = value;
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int i : nums
        ) {
            System.out.println(i);

        }
    }
}
