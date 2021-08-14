package com.topFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listOfLists = new ArrayList();
        return findPermutations(nums, 0, listOfLists);
    }

    private static List<List<Integer>> permuteRecursively(int[] nums, int start, int end) {
        List<List<Integer>> permutations = new LinkedList<>();
        if (start == end) {
            List<Integer> currList = new LinkedList<>();
            currList.add(nums[start]);
            permutations.add(currList);
        } else {
            List<List<Integer>> prevLists = permuteRecursively(nums, start + 1, end);
            for (List<Integer> list : prevLists) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> tempList = new LinkedList<>(list);
                    tempList.add(i, nums[start]);
                    permutations.add(tempList);
                }
            }
        }
        return permutations;
    }

    private static List<List<Integer>> findPermutations(int[] nums, int start, List<List<Integer>> listOfLists) {
        if (start == nums.length) {
            listOfLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = start; i < nums.length; i++) {
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
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }


}
