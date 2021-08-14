package com.topFifty;

import java.util.HashSet;

public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        return findPermutation(n, k, n,set,builder);
    }

    private static String findPermutation(int n, int rank, int max,HashSet<Integer> set,StringBuilder builder) {
        int totalCombinations = factorial(n);
        if (totalCombinations == rank) {
            return builder.append(numbersInDescendingOrder(max, set)).toString();
        } else if (rank % factorial(n - 1) == 0) {
            int next = findNthNumber(rank / factorial(n - 1), set);
            set.add(next);
            builder.append(next);
            return findPermutation(n - 1, factorial(n - 1), max, set, builder);
        } else {
            int next = findNthNumber(rank / factorial(n - 1) + 1, set);
            set.add(next);
            builder.append(next);
            return findPermutation(n - 1, rank % factorial(n - 1), max, set, builder);
        }
    }

    private static int findNthNumber(int n,HashSet<Integer> set) {
        int output = 1;
        for (int i = 1; i < n; ) {
            if (set.contains(output)) {
                output++;
                continue;
            }
            output++;
            i++;
        }
        while(set.contains(output)){
            output++;
        }
        return output;
    }


    private static int factorial(int n) {
        int factorial = 1;
        for (int i = n; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    private static String numbersInDescendingOrder(int n,HashSet<Integer> set) {
        StringBuilder output = new StringBuilder();
        for (int i = n; i > 0; ) {
            if (!set.contains(i)) {
                output.append(i);
            }

            i--;
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 1));
    }
}
