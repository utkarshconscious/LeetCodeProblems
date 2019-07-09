package com.Strings;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int index0=0;
        int index1=numbers.length-1;

        while(index0<index1){
            if (Math.addExact(numbers[index0],numbers[index1])==target){
                return new int [] {index0+1,index1+1};
            }
            else if (Math.addExact(numbers[index0],numbers[index1])>target){
                index1--;
            }
            else if (Math.addExact(numbers[index0],numbers[index1])<target){
                index0++;
            }

        }
        return null;
    }

    public static void main (String [] args){
        int [] nums = {-1,0};
        int [] output = new TwoSum().twoSum(nums,-1);
        for (int value : output) {
            System.out.println(value);
        }
    }
}
