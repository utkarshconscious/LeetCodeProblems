package com.topFifty;


public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (nums1.length == 0) {
            int x = (nums2.length - 1) / 2;
            if (nums2.length % 2 == 0) {
                int y = x + 1;
                return (double)(nums2[x] + nums2[y]) / 2;
            }
            return nums2[x];
        }
        int halfOfCombinedLen = (nums1.length + nums2.length + 1) / 2;
        int high = nums1.length;
        int low = 0;
        Double median = null;
        while (high >= low) {
            int partitionX = (high + low) / 2;
            int partitionY = halfOfCombinedLen - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    median = (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    median = (double) Math.max(maxLeftX, maxLeftY);
                }
                break;
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else if (maxLeftY > minRightX) {
                low = partitionX + 1;
            }

        }
        // if median is null then the two arrays are not sorted.
        return median;
    }

    public static void main(String args[]) {
        int[] num1 = {2,3};
        int[] num2 = {};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
