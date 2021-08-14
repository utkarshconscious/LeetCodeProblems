package com.topFifty;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsWhenDupsArePresent {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> listOfLists = new ArrayList();
        return findPermutations(nums, 0, listOfLists);
    }

    private static List<List<Integer>> findPermutations(int[] nums, int start, List<List<Integer>> listOfLists) {
        if (start == nums.length) {
            listOfLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if(set.contains(nums[i])){
                    continue;
                }
                set.add(nums[i]);
                swap(i, start, nums);
                findPermutations(nums, start + 1, listOfLists);
                swap(i, start, nums);
            }
        }
        return listOfLists;
    }

    private static void swap(int i, int start, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        System.out.println(permuteUnique(nums));
    }


}
