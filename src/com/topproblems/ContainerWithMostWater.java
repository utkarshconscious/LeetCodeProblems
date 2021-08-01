package com.topproblems;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < height.length && j > i; ) {
            int currentArea = Math.min(height[i], height[j]) * (j - i);
            maxArea = currentArea > maxArea ? currentArea : maxArea;
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }

    public static void main(String [] args){

   //     int [] arr = {1,8,6,2,5,4,8,3,7};
        int [] arr = {1,1,3,2};
        System.out.println(maxArea(arr));
    }
}
