package com.topFifty;

public class RegularExpressionMatchingRecursion {
    public static boolean isMatch(String s, String p) {
        return match(s, p, 0, 0);
    }

    private static boolean match(String s, String p, int sIndex, int pIndex) {
        boolean flag = false;
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }else if(pIndex == p.length()){
            return false;
        }

        if (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) {
            flag = true;
        }

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*' && flag) {
            return match(s, p, sIndex + 1, pIndex) || match(s, p, sIndex + 1, pIndex + 2);
        } else if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*' && !flag) {
            return match(s, p, sIndex, pIndex + 2);
        } else if (flag) {
            return match(s, p, sIndex + 1, sIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", "a*b*"));
    }

}
