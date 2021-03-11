package com.arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        int greatestRightElement = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = greatestRightElement;
            if (temp > greatestRightElement) {
                greatestRightElement = temp;
            }
        }
        return arr;
    }

    public static void main(String [] args){
        int[] nums = {1,1,2,7, 2, 4, 5,5, 6};
        new ReplaceElementsWithGreatestElementOnRightSide().replaceElements(nums);
        for (int value : nums) {
            System.out.print(value);
        }
    }
}
