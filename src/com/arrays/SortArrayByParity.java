package com.arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {


        int len = 0;
        for (int i=0; i<A.length; i++) {
            int ele = A[i];
            if (ele%2 == 0) {
                A[i] = A[len];
                A[len++] = ele;
            }
        }
        return A;
//        for (int i = 0, j = A.length - 1; i < j; ) {
//
//            if (numberEven(A[j]) && !numberEven(A[i])) {
//                int temp = A[i];
//                A[i++] = A[j];
//                A[j--] = temp;
//            } else if (!numberEven(A[j])) {
//                j--;
//            } else {
//                i++;
//            }
//
//        }
//        return A;
    }

    private boolean numberEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,3,3,4,5,3,3,3,6};
        new SortArrayByParity().sortArrayByParity(nums);
        for (int value : nums) {
            System.out.print(value+", ");
        }
        System.out.println();
    }
}
