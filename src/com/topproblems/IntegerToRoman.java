package com.topproblems;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    private static Map<Integer, String> mapping = new HashMap<>();

    static {
        mapping.put(1, "I");
        mapping.put(4, "IV");
        mapping.put(5, "V");
        mapping.put(9, "IX");
        mapping.put(10, "X");
        mapping.put(40, "XL");
        mapping.put(50, "L");
        mapping.put(90, "XC");
        mapping.put(100, "C");
        mapping.put(400, "CD");
        mapping.put(500, "D");
        mapping.put(900, "CM");
        mapping.put(1000, "M");
    }

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num < 1) {
            return "";
        }
        while (num >= 1000) {
            stringBuilder.append(mapping.get(1000));
            num -= 1000;
        }

        if (num >= 900) {
            num -= 900;
            stringBuilder.append(mapping.get(900));
        }
        if (num >= 500) {
            stringBuilder.append(mapping.get(500));
            num -= 500;
        }
        if (num >= 400) {
            stringBuilder.append(mapping.get(400));
            num -= 400;

        }
        while (num >= 100) {
            stringBuilder.append(mapping.get(100));
            num -= 100;
        }
        if (num >= 90) {
            stringBuilder.append(mapping.get(90));
            num -= 90;
        }
        if (num >= 50) {
            stringBuilder.append(mapping.get(50));
            num -= 50;
        }
        if (num >= 40) {
            stringBuilder.append(mapping.get(40));
            num -= 40;
        }
        while (num >= 10) {
            stringBuilder.append(mapping.get(10));
            num -= 10;
        }
        if (num == 9) {
            num -= 9;
            stringBuilder.append(mapping.get(9));
        } else if (num >= 5) {
            stringBuilder.append(mapping.get(5));
            num -= 5;

        } else if (num == 4) {
            stringBuilder.append(mapping.get(4));
            num -= 4;
        }
        while (num > 0) {
            num--;
            stringBuilder.append(mapping.get(1));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1000));
    }
}
