package com.TwoDArrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (numRows==0)
            return new ArrayList<>();
        else if (numRows==1) {
            List<Integer> list = new ArrayList<Integer>(1);
            list.add(1);
            output.add(list);
            return output;
        }
        else {
            List<Integer> list = new ArrayList<Integer>(1);
            list.add(1);
            output.add(list);
            List<Integer> previousList = new ArrayList<Integer>();
            List<Integer> currList= new ArrayList<Integer>();
            previousList.add(1);
            previousList.add(1);
            output.add(previousList);
            int j=3;
            while(j<=numRows) {
                currList.add(1);
                for (int i = 1; i < j - 1; i++) {
                    currList.add(previousList.get(i) + previousList.get(i - 1));
                }
                currList.add(1);

                output.add(currList);
                previousList = currList;
                currList = new ArrayList<>();
                j++;

            }
            return output;
        }

    }

    public static void  main(String [] args){
        int i =5;
        System.out.println(new PascalTriangle().generate(10));
    }
}
