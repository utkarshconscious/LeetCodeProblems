package com.topFifty;

public class StringToIntegerATOI {
    public static int myAtoi(String s) {
        int i = 0;
        int multiplier = 1;
        long output = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            multiplier = -multiplier;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) >= '0' && s.charAt(j) <= ('0' + 9)) {
                output = (output * 10) + (s.charAt(j) - '0');
                if (output > ((long)Integer.MIN_VALUE*-1)) {
                    break;
                }
            } else {
                break;
            }
        }

        output *= multiplier;
        if (output < Integer.MIN_VALUE) {
            output = Integer.MIN_VALUE;
        } else if (output > Integer.MAX_VALUE) {
            output = Integer.MAX_VALUE;
        }

        return (int) output * multiplier;
    }

    public static void main(String[] args) {
        char c = '0';
        System.out.println(myAtoi("    -42"));
    }
}
