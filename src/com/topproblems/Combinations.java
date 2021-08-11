package com.topproblems;

/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.
*/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
   static List<List<Integer>> combinations = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinationsUsingBacktracking(1, k, n, new ArrayList<Integer>(), combinations);
        return combinations;
    }

    private static void generateCombinationsUsingBacktracking(int start, int k, int n, ArrayList<Integer> integers, List<List<Integer>> combinations) {
        if (integers.size() == k) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(integers);
            combinations.add(temp);
        }
        for (int i = start; i <= n; i++) {
            integers.add(i);
            generateCombinationsUsingBacktracking(i + 1, k, n, integers, combinations);
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
