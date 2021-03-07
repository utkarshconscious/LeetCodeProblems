package com.arrays;

public class NumberPlusOne {

    /*public int[] plusOne(int[] digits) {
        int i=0;
        if (digits[digits.length-1]<9)
            digits[digits.length-1]=digits[digits.length-1]+1;
        else{
            while (i<digits.length){
                if (digits[digits.length-(i+1)]==9) {
                    digits[digits.length - (i + 1)] = 0;
                    i++;
                }
                else{
                    digits[digits.length-(i+1)]=digits[digits.length-(i+1)]+1;
                    break;
                }

            }
        }
        if (i==digits.length){
            int [] nums = new int[digits.length+1];
            nums[0]=1;
            for(int j=0;j<digits.length;j++)
                nums[j+1]=digits[j];
            digits=nums;
        }
        return digits;
    }*/

    public int[] plusOne(int[] digits) {
        int[] result = new int[0];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                result = digits;
                break;
            }
        }
        if (result.length == 0) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 8};
        nums = new NumberPlusOne().plusOne(nums);
        for (int value : nums) {
            System.out.print(value);
        }
    }
}
