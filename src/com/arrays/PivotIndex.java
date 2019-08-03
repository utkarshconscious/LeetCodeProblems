package com.arrays;

public class PivotIndex {

    public int pivotIndex(int[] nums) {

        int total=0;

        if (nums.length==0)
            return -1;
        int sumleft = 0;
        for (int i=0;i<nums.length;i++){
            total=total+nums[i];
        }

            for (int mid=0;mid<nums.length;mid++){
                if (sumleft==(total-nums[mid]-sumleft))
                    return mid;
                sumleft=sumleft+nums[mid];

            }
            return -1;
    }


    public static void main(String [] args){
        int [] nums = {-1,-1,-1,-1,-1,0};
        System.out.println(new PivotIndex().pivotIndex(nums));
    }
}
