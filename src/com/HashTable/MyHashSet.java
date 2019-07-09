package com.HashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {


    LinkedList<Integer>[] arr = new LinkedList[1000];

    public MyHashSet() {

    }

    public void add(int key) {
        int index = key % 1000;
        LinkedList<Integer> list = arr[index];
        if (list == null)
            list = new LinkedList<>();
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) == key) {
                break;
            }
        }
        if(i==list.size()) {
            list.add(key);
            arr[index] = list;
        }

    }

    public void remove(int key) {
        int index = key % 1000;
        LinkedList<Integer> list = arr[index];
        if (list == null)
            return;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                list.remove(i);
                break;
            }
        }

    }



    public boolean contains(int key) {
        int index = key % 1000;
        LinkedList<Integer> list = arr[index];
        if (list == null)
            return false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {

        //    Your MyHashSet object will be instantiated and called as such:
        int key = 100;

        MyHashSet obj = new MyHashSet();
        obj.add(key);
        key=99;
        obj.add(key);
        key=1000000;
        obj.add(key);
        key=1001;
        obj.add(key);
        obj.remove(99);
     //   obj.remove(key);
        System.out.println(obj.contains(99));
    }
}

