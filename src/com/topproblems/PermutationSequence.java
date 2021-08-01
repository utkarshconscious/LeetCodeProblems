package com.topproblems;

import java.util.HashSet;

/*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        Given n and k, return the kth permutation sequence.*/
public class PermutationSequence {
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder builder = new StringBuilder();

    public static String getPermutation(int n, int k) {

        return findPermutation(n, k, n);
    }

    private static String findPermutation(int n, int rank, int max) {
        int totalCombinations = factorial(n);
        if (totalCombinations == rank) {
            return builder.append(numbersInDescendingOrder(max)).toString();
        } else if (rank % factorial(n - 1) == 0) {
            set.add(findNthNumber(max, rank / factorial(n - 1)));
            builder.append(findNthNumber(max, rank / factorial(n - 1)));
            return findPermutation(n-1, factorial(n - 1), max);
        } else {
            set.add(findNthNumber(max, (rank / factorial(n - 1))+1));
            builder.append(findNthNumber(max, (rank / factorial(n - 1)))+1);
            return findPermutation(n - 1, rank%factorial(n - 1), max);
        }
    }

    private static int findNthNumber(int max, int n) {
        int output = 1;
        for (int i = 1; i < n; ) {
            if (set.contains(output)) {
                output++;
                continue;
            }
            output++;
            i++;
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

    private static String numbersInDescendingOrder(int n) {
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
        //   System.out.println(factorial(5));
        System.out.println(getPermutation(4, 6));
    }
}
