package com.HashTable;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        if (strs.length==0)
            return null;
       for(int i=0;i<strs.length;i++){

           char [] ca = strs[i].toCharArray();
           Arrays.sort(ca);
           if(map.containsKey(String.valueOf(ca))){
               map.get(String.valueOf(ca)).add(strs[i]);
               continue;
           }
           List<String> str = new ArrayList<>();
           str.add(strs[i]);
           map.put(String.valueOf(ca),str);

       }
        return new ArrayList<>(map.values());
    }

    public static void main (String [] args){
        GroupAnagrams ga = new GroupAnagrams();
        String [] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
       List l= new GroupAnagrams().groupAnagrams(str);
        System.out.println(l);
    }

}
