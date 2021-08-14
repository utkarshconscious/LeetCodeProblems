package com.topFifty;

import java.util.HashSet;
import java.util.Set;

public class UniqueString {
//zyzyzyz
    public static int solution(String S){

        if(S==null||S.length()==0){
            return 0;
        }
        for (int i = 1; i < S.length(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < S.length()-(i-1); j++) {
                String sample = S.substring(j,j+i);
                if(!set.contains(sample) && S.lastIndexOf(sample)==j){
                    return i;
                }
                set.add(sample);
            }
        }
        return S.length();
    }
    public static void main(String [] args){
        System.out.println(solution("aabbddeeddggf"));
    }
}
