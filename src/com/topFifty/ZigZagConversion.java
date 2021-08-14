package com.topFifty;


public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (s.length() == 0||numRows==1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        int stringIndex = 0;
        int arrayIndex = 0;
        boolean moveDown = false;

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        while (stringIndex < s.length()) {
            sbs[arrayIndex].append(s.charAt(stringIndex));
            stringIndex++;
            if (arrayIndex == 0 || arrayIndex == sbs.length - 1) {
                moveDown = !moveDown;
            }
            if (moveDown) {
                arrayIndex++;
            } else {
                arrayIndex--;
            }
        }

        StringBuilder output = new StringBuilder();
        for (StringBuilder sb : sbs) {
            output.append(sb);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println((long)Integer.MAX_VALUE);
        System.out.println(convert("AB", 1));
    }
}
