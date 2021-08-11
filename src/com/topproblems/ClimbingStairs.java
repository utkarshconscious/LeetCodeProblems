package com.topproblems;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] possibilityTable = new int[n + 1];
        if (n <= 2) {
            return n;
        }
        possibilityTable[n] = 1;
        possibilityTable[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            possibilityTable[i] = possibilityTable[i + 1] + possibilityTable[i + 2];
        }
        return possibilityTable[0];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
