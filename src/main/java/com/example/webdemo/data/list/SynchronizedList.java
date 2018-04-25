package com.example.webdemo.data.list;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * ConcurrentLinkedQueue线程安全(并发)
 * Collections.synchronizedList线程安全(阻塞)
 */
public class SynchronizedList {

//    private static Queue<String> queue = new LinkedList<>();
//    private static Queue<String> queue = new ConcurrentLinkedQueue<>();
    private static Set<String> queue = new ConcurrentSkipListSet<>();
//    private static List<String> queue = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        new MyThread("Th-01-").start();
        new MyThread("Th-02-").start();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6){
                String val = Thread.currentThread().getName() + i;
                queue.add(val);
                printAll();
            }
            super.run();
        }
    }

    private static void printAll(){
//        String value;
//        for (String aQueue : queue) {
//            value = aQueue;
//            System.out.print(value + ", ");
//        }
        System.out.println(queue);
    }
}
