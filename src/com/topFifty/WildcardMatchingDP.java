package com.topFifty;

import java.util.Locale;

public class WildcardMatchingDP {

    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int patternIndex = 0;
        boolean isFirst = true;

        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[patternIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[patternIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean[][] T = new boolean[s.length() + 1][patternIndex + 1];
        T[0][0] = true;
        if (patternIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < patternIndex + 1; j++) {
                if (pattern[j - 1] == '?' || pattern[j - 1] == str[i - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i][j - 1] || T[i - 1][j];
                }
            }

        }

        return T[str.length][patternIndex];

    }

    public static void main(String[] args) {
        String text = "aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab";
        String pattern = "*ab***ba**b*b*aaab*b";

        System.out.println(isMatch(text, pattern));
    }
}