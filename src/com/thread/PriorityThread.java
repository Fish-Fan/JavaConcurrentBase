package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanfeng-mac on 2017/10/26.
 */
public class PriorityThread implements Runnable {
    private int priority;
    private int countDown = 5;
    private volatile double d;

    public PriorityThread(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for(int i =1;i < 10000;i++) {
            d += (Math.PI + Math.E) / i;
            if(i % 1000 == 0) {
                Thread.yield();
            }
        }

        System.out.println(this);
        if(--countDown == 0) {
            return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new PriorityThread(Thread.MIN_PRIORITY));
        exec.execute(new PriorityThread(Thread.MAX_PRIORITY));

        exec.shutdown();
    }
}
