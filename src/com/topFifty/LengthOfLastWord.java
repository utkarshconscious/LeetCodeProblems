package com.topFifty;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
         s = s.trim();
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)==' '){
                return s.length()-1-i;
            }
        }
        return s.length();

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }
}
