package com.HashTable;

import java.util.*;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
        {
            return false;
        }
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i-1; j > -1; j--)
            {
                if(nums[i] > nums[j])
                {
                    break;
                }
                else if(nums[i] == nums[j])
                {
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDufplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length==0)
            return false;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main (String [] args){

        int [] nums = {1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }
}
