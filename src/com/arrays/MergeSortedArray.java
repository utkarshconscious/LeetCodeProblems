package com.arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }



//    int i = 0;
//    int j = 0;
//    int[] output = new int[nums1.length];
//    int index = 0;
//        while (i < m && j < n) {
//        if (nums1[i] > nums2[j]) {
//            output[index] = nums2[j];
//            j++;
//        } else {
//            output[index] = nums1[i];
//            i++;
//        }
//        index++;
//    }
//        while (i < m) {
//        output[index] = nums1[i];
//        i++;
//        index++;
//    }
//        while (j < n) {
//        output[index] = nums2[j];
//        j++;
//        index++;
//    }
//
//        for (int l = 0; l < output.length; l++) {
//        nums1[l] = output[l];
//    }
}
