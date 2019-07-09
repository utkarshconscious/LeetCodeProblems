package com.Queue;

import com.LinkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {

    int [] queue;
    int head=-1,tail=-1;
    int size =0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.size=k;
        queue = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if(tail>=head && tail<size-1){
            if(isEmpty())
                head=0;
            tail++;
            queue[tail]=value;
            return true;
        }
        else if(tail<head && head-tail>1){
            tail++;
            queue[tail]=value;
            return true;
        }
        else if(tail==size-1 && head>0){
            tail =0;
            queue[0]=value;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(head==-1)
            return false;
        else if(head==tail){
            head=-1;
            tail=-1;
            return true;
        }
        else if(head<size-1){
            head++;
            return true;
        }
        else if(head==size-1){
            head=0;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(head==-1)
            return -1;
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(head==-1)
            return -1;
        return queue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==-1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        System.out.println(head+" "+tail);
        if((head==0&&tail==size-1)|| (tail<head && head-tail==1))
            return true;
        return false;
    }

    public static void main(String args []){

        MyCircularQueue queue = new MyCircularQueue(6);
        queue.enQueue(6);
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        queue.deQueue();
        queue.enQueue(5);
        System.out.println(queue.Rear());
        queue.deQueue();
        System.out.println(queue.Front());

        queue.deQueue();
        queue.deQueue();
    }
}
/*
class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    *//** Initialize your data structure here. Set the size of the queue to be k. *//*
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    *//** Insert an element into the circular queue. Return true if the operation is successful. *//*
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    *//** Delete an element from the circular queue. Return true if the operation is successful. *//*
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    *//** Get the front item from the queue. *//*
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    *//** Get the last item from the queue. *//*
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    *//** Checks whether the circular queue is empty or not. *//*
    public boolean isEmpty() {
        return head == -1;
    }

    *//** Checks whether the circular queue is full or not. *//*
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}*/

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */