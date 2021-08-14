package com.topFifty;

import java.util.ArrayList;
import java.util.List;

public class TestClass implements Runnable {

    public static void main(String[] args) {
//        Thread t = new Thread(new TestClass());
//        t.start();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new TestClass()));
        }
        for (int i = 0; i < 10; i++) {
            threads.get(i).start();
        }

    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
