package com.topFifty;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        String output = null;
        boolean[][] table = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            table[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 1) {
                    table[j][j + i] = s.charAt(j) == s.charAt(j + i);
                } else {
                    table[j][j + i] = s.charAt(j) == s.charAt(j + i) && table[j + 1][j + i - 1] == true;
                }
                if (table[j][j + i]) {
                    maxLength = i+1 > maxLength ? i+1 : maxLength;
                    output = s.substring(j, j + i + 1);
                }
            }
        }
        System.out.println(maxLength);
        return output != null ? output : s.substring(0, 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
