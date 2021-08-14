package com.topFifty;

import java.util.Arrays;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int index = binarySearch(nums, 0, nums.length - 1, target);

        return index;
    }

    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return low;

        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        else if (low == high) {
            if (key < arr[mid]) {
                return mid;
            } else {
                return mid + 1;
            }
        }
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 8};

        System.out.println(searchInsert(nums, 4));
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 6));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 8));
        System.out.println(searchInsert(nums, 9));
        System.out.println(searchInsert(nums, 10));
    }
}
