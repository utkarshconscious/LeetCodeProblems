package com.HashTable;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        Integer other;

        for(int i=0;i<nums.length;i++){
            other = target-nums[i];
            if(map.containsKey(other)){
                return new int[] { map.get(other), i };
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
