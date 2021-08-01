package com.arrays;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1] = -nums[Math.abs(index)-1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums));
    }
}
