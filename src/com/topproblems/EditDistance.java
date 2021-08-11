package com.topproblems;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                int word1Index = j - 1;
                int word2Index = i - 1;
                if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
