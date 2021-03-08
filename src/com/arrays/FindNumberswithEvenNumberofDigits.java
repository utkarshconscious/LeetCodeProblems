package com.arrays;

public class FindNumberswithEvenNumberofDigits {

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (numberLengthEven(num)) {
                count++;
            }
        }
        return count;
    }


    private static boolean numberLengthEven(int input) {
        int length = 1;
        if (input < 0)
            return false;
        while (input / 10 > 0) {
            input = input / 10;
            length++;
        }
        return length % 2 == 0;
    }

    public static void main(String[] args) {
        int array[] = { 1, 21, 311, 1114, 51111 };

        System.out.println(numberLengthEven(3));

        System.out.println(findNumbers(array));

    }
}
