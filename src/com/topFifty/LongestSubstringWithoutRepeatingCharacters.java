package com.topFifty;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        int max = 0;
        int len = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!uniqueChars.contains(s.charAt(i))) {
                uniqueChars.add(s.charAt(i));
                len++;
            } else {
                max = Math.max(max, len);
                int j = start;
                while (s.charAt(j) != s.charAt(i)) {
                    uniqueChars.remove(s.charAt(j++));
                    len--;
                }
                start = ++j;
            }
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaabcbb"));
    }
}
