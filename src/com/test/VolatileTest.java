package com.test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yanfeng-mac on 2017/11/19.
 */
public class VolatileTest {
    private static CountDownLatch c = new CountDownLatch(10);
    private static volatile int j = 0;
    public static class Add implements Runnable {

        @Override
        public void run() {
            c.countDown();
            for(int k = 0;k < 10000;k++)
                j++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i =0;i < 10;i++) {
            threads[i] = new Thread(new Add());
            threads[i].start();
        }

        c.await();


        System.out.println(j);
    }
}
