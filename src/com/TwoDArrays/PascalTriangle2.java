package com.TwoDArrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> generate(int numRows) {

        if (numRows==0) {
            List<Integer> list = new ArrayList<Integer>(1);
            list.add(1);
            return list;
        }
        else if (numRows==1) {
            List<Integer> list = new ArrayList<Integer>(1);
            list.add(1);
            list.add(1);
            return list;
        }
        else {
            List<Integer> previousList = new ArrayList<Integer>();
            List<Integer> currList= new ArrayList<Integer>();
            previousList.add(1);
            previousList.add(1);
            int j=2;
            while(j<=numRows) {
                currList = new ArrayList<>();
                currList.add(1);
                for (int i = 1; i < j ; i++) {
                    currList.add(previousList.get(i) + previousList.get(i - 1));
                }
                currList.add(1);
                previousList = currList;
                j++;

            }
            return previousList;
        }

    }

    public static void  main(String [] args){
        int i =5;
        System.out.println(new PascalTriangle2().generate(3));
    }
}
