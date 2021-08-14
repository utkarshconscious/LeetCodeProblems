package com.topFifty;

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<String> stack= new Stack<>();
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==')'){
                continue;
            }
            stack.clear();
            for (int j = i; j < arr.length; j++) {
                if(arr[j]=='('){
                    stack.push("(");
                }else{
                    if(!stack.empty()) {
                        stack.pop();
                        if (stack.empty()) {
                            max = Math.max(max, j - i + 1);
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String [] args){
        System.out.println(longestValidParentheses(")()())()()("));
    }
}
