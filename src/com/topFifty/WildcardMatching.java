package com.topFifty;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        else if(s.length()==0){
            char [] pattern = p.toCharArray();
            int i = 0;
            for (; i < pattern.length; i++) {
                    if(pattern[i] == '*'){
                        continue;
                    }
                    break;
            }
            if(i==pattern.length){
                return true;
            }
            else{
                return false;
            }
        }
        return match(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private static boolean match(char[] text, char[] pattern, int textIndex, int patternIndex) {

        if (textIndex == text.length && patternIndex == pattern.length) {
            return true;
        }
        else if(textIndex == text.length && pattern[patternIndex] == '*'){
            return  match(text, pattern, textIndex, patternIndex + 1);
        }
        else if (textIndex == text.length || patternIndex == pattern.length) {
            return false;
        } else if (text[textIndex] == pattern[patternIndex] || pattern[patternIndex] == '?') {
            return match(text, pattern, textIndex + 1, patternIndex + 1);
        } else if(pattern[patternIndex] == '*'){
            return match(text, pattern, textIndex + 1, patternIndex) || match(text, pattern, textIndex + 1, patternIndex+1)
                    || match(text, pattern, textIndex, patternIndex+1);

        }
        else {
            return false;
        }
    }

    public static void main(String [] args){
        String text = "aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab";
        String pattern ="*ab***ba**b*b*aaab*b";

        System.out.println(isMatch(text,pattern));
    }
}
