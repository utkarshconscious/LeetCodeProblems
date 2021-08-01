package com.topproblems;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int index = findPosition(intervals, newInterval);

        int[][] output = mergeIntervals(intervals, newInterval, index);
        for (int i = 0; i < output.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < output[i].length; j++) { //this equals to the column in each row.
                System.out.print(output[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
        return output;

    }

    private static int[][] mergeIntervals(int[][] intervals, int[] newInterval, int index) {
        LinkedList<int[]> mergedList = new LinkedList<>();
        int i = 0;
        while (i < index) {
            mergedList.add(intervals[i]);
            i++;
        }
        if (mergedList.isEmpty() || mergedList.getLast()[1] < newInterval[0]) {
            mergedList.add(Arrays.copyOf(newInterval, newInterval.length));
        } else {
            mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], newInterval[1]);
        }

        for (int j = index; j < intervals.length; j++) {
            int[] arr = intervals[j];
            if (mergedList.isEmpty() || mergedList.getLast()[1] < arr[0]) {
                mergedList.add(Arrays.copyOf(arr, arr.length));
            } else {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], arr[1]);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    private static int findPosition(int[][] intervals, int[] newInterval) {
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = {4,8};
        insert(intervals, newIntervals);
    }
}
