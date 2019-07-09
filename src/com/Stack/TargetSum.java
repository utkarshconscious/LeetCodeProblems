package com.Stack;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0, S, new HashMap<>());
    }
    private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map){
        String encodeString = index + "->" + sum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }
        if (index == nums.length){
            if (sum == S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper(nums, index + 1, sum - curNum, S, map);
        int minus = helper(nums, index + 1, sum + curNum, S, map);
        map.put(encodeString, add + minus);
        return add + minus;
    }

    public static void main(String [] args){
        int [] input ={1, 1, 1, 1, 1};
        System.out.println(new TargetSum().findTargetSumWays(input,3));
    }
}
