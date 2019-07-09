package com.HashTable;

import java.util.*;

public class MyHashMap {

    LinkedList<EntryMap>[] arr = new LinkedList[1000];

    public void put(int key,int value) {
        int index = key % 1000;
        LinkedList<EntryMap> list = arr[index];
        if (list == null)
            list = new LinkedList<>();
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                list.remove(i);
                list.add(new EntryMap(key,value));
                break;
            }
        }
        if(i==list.size()) {

            list.add(new EntryMap(key,value));
            arr[index] = list;
        }

    }

    public void remove(int key) {
        int index = key % 1000;
        LinkedList<EntryMap> list = arr[index];
        if (list == null)
            return;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                list.remove(i);
                break;
            }
        }

    }



   /* public boolean contains(int key) {
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

    }*/

    public int get(int key) {
        int index = key % 1000;
        LinkedList<EntryMap> list = arr[index];
        if (list == null)
            return -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                return list.get(i).value;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        //    Your MyHashSet object will be instantiated and called as such:
        int key = 100;
        int value =100;

        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
        obj.remove(2);obj.remove(2);
        System.out.println(obj.get(2));

    }
}
class EntryMap{
    public EntryMap(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    Integer key;
    Integer value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}