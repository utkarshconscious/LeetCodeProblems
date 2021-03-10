package com.arrays;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        int peak = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                peak = i - 1;
                break;
            } else if (arr[i] == arr[i - 1]) {
                return false;
            }
        }

        for (int i = peak + 1; i < arr.length; i++) {
            if (arr[peak] <= arr[i] || arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        return peak != 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 9, 5, 4, 1, 2};
        System.out.println(new ValidMountainArray().validMountainArray(nums));
    }
}
