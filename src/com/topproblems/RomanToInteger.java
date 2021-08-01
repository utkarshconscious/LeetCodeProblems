package com.topproblems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int romanToInt(String s) {
        int output = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                output -= map.get(s.charAt(i));
            } else {
                output += map.get(s.charAt(i));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
