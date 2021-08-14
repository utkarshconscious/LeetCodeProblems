package com.topFifty;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] output = {-1, -1};
        int i, j;
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return output;
        }

        if (index == nums.length - 1) {
            i = index;
        } else {
            i = findUpperLimit(nums, index + 1, nums.length - 1, target);
        }
        if (index == 0) {
            j = index;
        } else {
            j = findLowerLimit(nums, 0, index - 1, target);
        }

        output[0] = j;
        output[1] = i;

        return output;
    }

    static int findUpperLimit(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;
        if (mid == high && arr[mid]==key) {
            return mid;
        } else if (key == arr[mid]) {
           return findUpperLimit(arr, mid + 1, high, key);
        } else if (key == arr[mid - 1]) {
            return mid - 1;
        }
        return findUpperLimit(arr, low, mid - 1, key);

    }

    static int findLowerLimit(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (key == arr[mid] && mid == low) {
            return low;
        } else if (key == arr[mid]) {
           return findLowerLimit(arr, low, mid - 1, key);
        } else if (key == arr[mid + 1]) {
            return mid + 1;
        }
        return findLowerLimit(arr, mid + 1, high, key);
    }

    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }
}
