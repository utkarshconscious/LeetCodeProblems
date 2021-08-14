package com.topFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
//Note: The solution set must not contain duplicate combinations.

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        solveByBackTracking(candidates, combinations, 0, target, new ArrayList<>());
        return combinations;
    }

    private static void solveByBackTracking(int[] candidates, List<List<Integer>> combinations, int start, int target, List<Integer> currentList) {


        if (target == 0) {
            combinations.add(new ArrayList<>(currentList));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                currentList.add(candidates[i]);
                solveByBackTracking(candidates, combinations, i + 1, target - candidates[i], currentList);
                currentList.remove(currentList.size() - 1);
            }

        }
    }
}
