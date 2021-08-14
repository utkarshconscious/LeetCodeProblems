package com.topFifty;

import java.util.ArrayList;
import java.util.List;
//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        solveByBackTracking(candidates, combinations, 0, target, new ArrayList<>());
        return combinations;
    }

    private static void solveByBackTracking(int[] candidates, List<List<Integer>> combinations, int start, int target, List<Integer> currentList) {

        if (target == 0) {
            combinations.add(new ArrayList<>(currentList));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                solveByBackTracking(candidates, combinations, i, target - candidates[i], currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6,  5};
        System.out.println(combinationSum(candidates, 8));
    }
}




