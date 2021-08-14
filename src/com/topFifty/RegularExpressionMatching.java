package com.topFifty;
//86391
//36388
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        boolean T[][] = new boolean[s.length() + 1][p.length() + 1];

        T[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    T[i][j] = T[i][j - 2];
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                     //   T[i][j] = T[i - 1][j]  || T[i][j];
                        T[i][j] = T[i - 1][j]  ;
                    }
                }
            }
        }

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[0].length; j++) {
                System.out.print(T[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return T[s.length()][p.length()];
    }

    public static void main(String[] args) {
//        String text = "aaa";
//        String pattern = "ab*a*c*a";
        String text = "aaa";
        String pattern = "aa*b*a";
        System.out.println(isMatch(text, pattern));
    }
}
