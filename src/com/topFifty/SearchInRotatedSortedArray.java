package com.topFifty;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int output = -1;
        if (nums.length == 0) {
            return output;
        }
        else if(nums.length ==1){
            if(nums[0] == target){
                return 0;
            }
            return output;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (high >= low) {
            mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[low]) {
                if (target < nums[mid] && target >= nums[low]) {
                    return binarySearch(nums, low, mid, target);
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    return binarySearch(nums, mid, high, target);
                } else {
                    high = mid - 1;
                }
            }
        }
        return output;
    }

    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    public static void main(String[] args) {
        int[] words = {3,1};
        System.out.println(search(words, 1));
    }
}
