package com.arrays;

public class RotateArray {

/*    public void rotate(int[] nums, int k) {

        for (int i=0;i<k;i++){
            int temp= nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                int hold=nums[j];
                nums[j]=temp;
                temp=hold;
            }
        }
    }*/

    public void rotate(int[] nums, int k) {
         int [] a = new int [nums.length];

        for (int i=0;i<nums.length;i++){
            a[(i+k)%nums.length]=nums[i];
        }
        for (int i=0;i<nums.length;i++){
            nums[i]=a[i];
        }
    }

    public void rotateCyclic(int[] nums, int k) {
        k=k%nums.length;
        int count=0;
        for(int start = 0;count<nums.length;start++){
            int next=start;
            int temp=nums[start];
            do{
                next=(next+k)%nums.length;
                int hold = nums[next];
                nums[next]=temp;
                temp=hold;
                count++;

            }while (next!=start);
        }
    }


    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7};
       new RotateArray().rotateCyclic(nums,2);
        for (int value : nums) {
            System.out.print(value);
        }
    }
}
