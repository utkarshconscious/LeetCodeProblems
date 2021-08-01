package com.topproblems;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        return matchRecursively(s, p, 0, 0);
    }

    private static boolean matchRecursively(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        boolean firstMatch = sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex));

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            return matchRecursively(s, p, sIndex, pIndex + 2) || (firstMatch && matchRecursively(s, p, sIndex+1, pIndex));
        } else {
            return firstMatch && matchRecursively(s, p, sIndex + 1, pIndex + 1);
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "a*abc*d*f*";
        System.out.println(isMatch(s, p));
    }
}
