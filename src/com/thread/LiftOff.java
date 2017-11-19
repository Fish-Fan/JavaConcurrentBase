package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanfeng-mac on 2017/10/26.
 */
public class LiftOff implements Runnable{
    private int count = 10;
    private static int taskCount = 0;
    private int id = taskCount++;

    public void say() {
        System.out.println("#id->" + id + " (" + count + ")");
    }

    @Override
    public void run() {
        while (count-- > 0) {
            say();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for(int i = 0 ;i < 5;i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
