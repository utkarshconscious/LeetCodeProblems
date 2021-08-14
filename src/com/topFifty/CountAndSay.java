package com.topFifty;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

    public static  String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }
        List<Integer> prev = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        prev.add(1);
        prev.add(1);

        int i = 2;
        while (i < n) {
            i++;
            int number = 0;
            int count = 0;
            list = new ArrayList<>();
            for (int j = 0; j < prev.size(); j++) {
                if(j==0){
                    count++;
                    number =prev.get(j);
                    continue;
                }
                if (prev.get(j) == number) {
                    count++;
                } else {
                    list.add(count);
                    list.add(number);
                    number = prev.get(j);
                    count = 1;
                }
            }
            list.add(count);
            list.add(number);
            prev = list;
        }
        StringBuilder output = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            output = output.append(list.get(j));
        }

        return String.valueOf(output);
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(9));;
    }

}
