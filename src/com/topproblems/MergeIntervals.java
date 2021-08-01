package com.topproblems;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        sortIntervals(intervals);
        for (int i = 0; i < intervals.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < intervals[i].length; j++) { //this equals to the column in each row.
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
        intervals = mergeIntervals(intervals);
        for (int i = 0; i < intervals.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < intervals[i].length; j++) { //this equals to the column in each row.
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
        return mergeIntervals(intervals);
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        LinkedList<int[]> mergedList = new LinkedList<>();
        for (int[] arr : intervals) {
            if (mergedList.isEmpty() || mergedList.getLast()[1] < arr[0]) {
                mergedList.add(Arrays.copyOf(arr, arr.length));
            }else {
                mergedList.getLast()[1]= Math.max(mergedList.getLast()[1],arr[1]);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    private static void sortIntervals(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);
    }

    private static void sort(int[][] intervals, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(intervals, low, mid);
        sort(intervals, mid + 1, high);
        mergeSortedIntervals(low, mid, high, intervals);
    }

    private static void mergeSortedIntervals(int low, int mid, int high, int[][] intervals) {
        int[][] temp = new int[high - low + 1][2];
        int i = low, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (intervals[i][0] < intervals[j][0]) {
                temp[k++] = copyOf(intervals[i]);
                i++;
            } else {
                temp[k++] = copyOf(intervals[j]);
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = copyOf(intervals[i]);
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = copyOf(intervals[j]);
            j++;
            k++;
        }
        k = 0;
        for (int l = low; l <= high; l++) {
            intervals[l] = temp[k++];
        }
    }

    private static int[] copyOf(int[] interval) {
        return Arrays.copyOf(interval, interval.length);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {15, 18}, {2, 6}, {8, 10}};
        merge(arr);
    }
}
