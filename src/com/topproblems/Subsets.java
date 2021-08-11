package com.topproblems;

/*Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i < nums.length+1; i++) {
            createCombinations(i, 0, nums, new ArrayList<Integer>(), combinations);
        }
        return combinations;
    }

    private static void createCombinations(int i, int start, int[] nums, ArrayList<Integer> integers, List<List<Integer>> combinations) {
        if (integers.size() == i) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(integers);
            combinations.add(temp);
        } else {
            for (int j = start; j < nums.length; j++) {
                integers.add(nums[j]);
                createCombinations(i, j + 1, nums, integers, combinations);
                integers.remove(integers.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
