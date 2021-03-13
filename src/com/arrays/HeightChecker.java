package com.arrays;

import java.util.*;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            temp[i] = heights[i];
        }
        Arrays.sort(heights);
        int countOfStudentsMoved = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != heights[i]) {
                countOfStudentsMoved++;
            }
        }
        return countOfStudentsMoved;
    }

    public static void main(String [] args){
        int[] nums = {1, 1,2,9, 3, 4};
        System.out.println(new HeightChecker().heightChecker(nums));
    }
}
