package com.topFifty;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> solution(int n) {
        List<String> strings = new ArrayList<>();
        generateParenthesesUsingBackTracking("", 0, 0, n, strings);
        return strings;
    }

    private static void generateParenthesesUsingBackTracking(String s, int open, int close, int max, List<String> strings) {
        if (open + close == 2*max) {
            strings.add(s);
            return;
        }
        if (open < max) {
            generateParenthesesUsingBackTracking(s + "(", open+1, close, max, strings);
        }
        if (open > close) {
            generateParenthesesUsingBackTracking(s + ")", open, close+1, max, strings);
        }
    }

    public static void main(String [] args){
        System.out.println(solution(4));
    }
}
