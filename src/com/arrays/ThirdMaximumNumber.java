package com.arrays;

import java.util.*;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        Integer output = 0;
        boolean thirdMaxAvailable = false;
        for (int num : nums) {
            if (Objects.equals(num, firstMax) || Objects.equals(num, secondMax) || Objects.equals(num, thirdMax)) {
                continue;
            }
            if (firstMax == null || num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (secondMax ==null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (thirdMax ==null ||num > thirdMax) {
                thirdMax = num;
            }
        }
        System.out.println(firstMax+" "+secondMax+" "+thirdMax);
        if (thirdMax!=null) {
            output = thirdMax;
        } else {
            output = firstMax;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,5,3,5};
        System.out.println(new ThirdMaximumNumber().thirdMax(nums));
    }
}
