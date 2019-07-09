package com.Stack;

import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> stack = new ArrayList<>();


    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {

        stack.add(x);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        int min=stack.get(0);
        int i= 1;
        while(i<stack.size()){
            if(min>stack.get(i)){
                min=stack.get(i);
            }
            i++;
        }
        return min;
    }

    public static void main(String args[]) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(6);
        obj.push(-1);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        ArrayList<String> l = new ArrayList();
        l.add("some");
        String ls = l.get(0);


    }
}
