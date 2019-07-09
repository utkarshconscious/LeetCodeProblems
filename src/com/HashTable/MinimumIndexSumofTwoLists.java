package com.HashTable;

import javafx.scene.effect.*;

import java.util.*;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int sum= Integer.MAX_VALUE;
        ArrayList<String> output =new ArrayList<String>();


        for(int i=0;i<list2.length;i++){
            if(i>sum)
                break;
            if(map.containsKey(list2[i])){
                int temp=map.get(list2[i]);
                if(temp+i<sum) {
                    sum = temp + i;
                }
            }
        }
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int temp=map.get(list2[i]);
                if(temp+i==sum) {
                    output.add(list2[i]);
                }
            }
        }

        return output.toArray(new String[output.size()]);
    }

    public static void main (String [] args){
        String [] s = {"Shogun", "Tapioca Express", "BurgerKing", "KFC"};
        String [] t = {"KFC", "Shogun", "BurgerKing"};

        System.out.println(new MinimumIndexSumofTwoLists().findRestaurant(s,t)[2]);
    }
}
