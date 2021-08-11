package com.topproblems;

public class YourOwnMinHeap {

    private int heap[];
    private int lastIndex;

    public YourOwnMinHeap(int size) {
        this.heap = new int[size];
        this.lastIndex = -1;
    }

    public void printHeap() {
        for (int i : heap) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void addElement(int num) {
        if (lastIndex < heap.length) {
            heap[++lastIndex] = num;
            int curr = lastIndex;
            int parent = (lastIndex - 1) / 2;
            while (parent >= 0) {
                if (heap[parent] > heap[curr]) {
                    swap(heap, parent, curr);
                    curr = parent;
                    parent = (parent - 1) / 2;
                } else {
                    break;
                }
            }
        }
    }

    public int deleteMin() {
        int min = heap[0];
        heap[0] = heap[lastIndex];
        heap[lastIndex] = 0;
        lastIndex--;
        int curr = 0;
            printHeap();
        while (lastIndex>curr && curr <= (lastIndex - 1) / 2) {
            int left = heap[2 * curr + 1];
            int right = heap[2 * curr + 2];
            if (2 * curr + 2 <= lastIndex && Math.min(heap[2 * curr + 1], heap[2 * curr + 2]) < heap[curr]) {
                if (left < right) {
                    swap(heap, curr, 2 * curr + 1);
                    curr = 2 * curr + 1;
                } else {
                    swap(heap, curr, 2 * curr + 2);
                    curr = 2 * curr + 2;
                }
            } else if (left < heap[curr]) {
                swap(heap, curr, 2 * curr + 1);
                curr = 2 * curr + 1;
            } else {
                break;
            }

       //     System.out.println(curr+" "+ lastIndex);
        }printHeap();
        return min;
    }

    private void swap(int[] heap, int parent, int curr) {
        int temp = heap[parent];
        heap[parent] = heap[curr];
        heap[curr] = temp;
    }

    public int findMin() {
        System.out.println(heap[0]);
        return heap[0];
    }

    public static void main(String[] args) {
        YourOwnMinHeap minHeap = new YourOwnMinHeap(10);
    //    minHeap.addElement(1);
        minHeap.addElement(10);
        minHeap.addElement(9);
        minHeap.addElement(6);
        minHeap.addElement(11);
        minHeap.addElement(99);
        minHeap.deleteMin();
   //     minHeap.printHeap();
    }

}
