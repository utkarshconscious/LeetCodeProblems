package com.HashTable;

import java.util.*;

public class IsomorphicStrings {

// Alternate solution using array.
    /*public boolean isIsomorphic(String s, String t) {
        int [] used = new int[128];
        int [] rep = new int[128];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        for(int i=0;i<ss.length;i++) {
            if(rep[ss[i]] > 0) {
                if(rep[ss[i]] != ts[i]) return false;
            } else {
                if(used[ts[i]] == 1) return false;

                rep[ss[i]] = ts[i];
                used[ts[i]] = 1;
            }
        }

        return true;
    }*/
    public boolean isIsomorphic(String s, String t) {
        char [] s1 =s.toCharArray();
        char [] t1 =t.toCharArray();
        Map<Character,Character> map = new HashMap<>();

        for(int i=0;i<s1.length;i++){
            if(map.containsKey(s1[i])){
                if(map.get(s1[i]).equals(t1[i]))
                    continue;
                else
                    return false;
            }
            else if(map.containsValue(t1[i]))
                return false;
            map.put(s1[i],t1[i]);
        }
        return true;
    }

    public static void main (String [] args){
        String  s = "aa";
        String  t = "aa";

        System.out.println(new IsomorphicStrings().isIsomorphic(s,t));
    }
}
