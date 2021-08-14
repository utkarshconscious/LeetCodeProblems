package com.topFifty;

import java.util.*;

/*
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
You can return the answer in any order.
*/

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> anotherWordMap;
        int totalLength = words[0].length() * words.length;
        int wordLength = words[0].length();
        if (s.length() == 0 || s.length() < totalLength || totalLength == 0) {
            return output;
        }
        for (int i = 0; i < words.length; i++) {
            int count = wordMap.containsKey(words[i]) ? wordMap.get(words[i]) : 0;
            wordMap.put(words[i], count + 1);
        }

        for (int i = 0; i < s.length() - (totalLength - 1); i++) {
            anotherWordMap = new HashMap<>();
            String sample = s.substring(i, totalLength + i);
            int j = 0;
            for (; j < sample.length(); j += wordLength) {
                String subSample = sample.substring(j, j + wordLength);
                if (wordMap.containsKey(subSample)) {
                    int count = anotherWordMap.containsKey(subSample) ? anotherWordMap.get(subSample) : 0;
                    anotherWordMap.put(subSample, count + 1);
                } else {
                    break;
                }
            }
            if (j == sample.length() && wordMap.equals(anotherWordMap)) {
                output.add(i);
            }

        }
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        String s = "";

        String[] words = {""};
        findSubstring(s, words);
    }
}
