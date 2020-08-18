package com.codility;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        out[0] = 1;
        out[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            out[i] = out[i - 1] * nums[i - 1];
        }

        System.out.println();
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] = out[i] * r;
            r = r * nums[i];
            System.out.println(out[i]);
        }
        return out;
    }

    public static void main(String[] args) {
        int[] array = productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
