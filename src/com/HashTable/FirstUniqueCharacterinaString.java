package com.HashTable;

import java.util.*;

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        char [] c = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        int [] arr = new int[s.length()];
        for(int i =0;i<c.length;i++){

            if(map.containsKey(c[i])){
                arr[map.get(c[i])]=0;
                continue;
            }
            arr[i]=1;
            map.put(c[i],i);
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]==1)
                return i;
        }

        return -1;
    }

    public static void main (String [] args){
        String s = "loveleetcode";
        System.out.println(new FirstUniqueCharacterinaString().firstUniqChar(s));
    }
}
