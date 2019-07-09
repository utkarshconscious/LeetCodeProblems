package com.HashTable;

import java.util.*;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<Integer>();
        int i=0,j=0;

        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;j++;
            }
            else if (nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        int [] output = new int [set.size()];
            int k=0;
        for (Integer num : set) {
            output[k++] = num;
        }
        return output;
    }

    public static void main (String [] args){
        int [] num1= {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        int [] output =new IntersectionofTwoArrays().intersection(num1,nums2);
        for(Integer i : output){
            System.out.println(i);
        }
    }

}
