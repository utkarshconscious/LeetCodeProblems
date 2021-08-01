package com.topproblems;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i];
            List<List<Integer>> twoSumLists = twoSum(nums, i + 1, -target);
            for (List<Integer> list : twoSumLists) {
                List<Integer> threeSumList = new ArrayList<>();
                threeSumList.add(target);
                threeSumList.addAll(list);
                if (!output.contains(threeSumList)) {
                    output.add(threeSumList);
                }
            }
        }
        return output;
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                List<Integer> list = Arrays.asList(nums[i], compliment);
                output.add(list);
                map.remove(compliment);
            } else {
                map.put(nums[i], i);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums2 = {0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2};
        System.out.println(threeSum(nums2));
    }
}
