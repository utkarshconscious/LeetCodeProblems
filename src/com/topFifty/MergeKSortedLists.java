package com.topFifty;
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode outputHead = new ListNode();
        ListNode currentNode = outputHead;
        Integer min;
        Integer index;

        do {
            index = null;
            min = null;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] == null){
                    continue;
                }
                if (min == null || lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (min != null) {
                currentNode.next = new ListNode(min);
                currentNode = currentNode.next;
                lists[index] = lists[index].next;
            }

        } while (min != null);

        return outputHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}