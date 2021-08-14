package com.topFifty;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        populateLeftAuxiliaryArray(height, left);
        populateRightAuxiliaryArray(height, right);
        int area = 0;
        int minHeight;
        for (int i = 1; i < height.length - 1; i++) {
             minHeight = Math.min(left[i], right[i]);
            if (minHeight > height[i]) {
                area += (minHeight - height[i]);
            }
        }
        return area;
    }

    private static void populateRightAuxiliaryArray(int[] height, int[] right) {
        int max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }
    }

    private static void populateLeftAuxiliaryArray(int[] height, int[] left) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            left[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }
}
