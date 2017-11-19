package com.concurrentutil;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yanfeng-mac on 2017/11/13.
 */
public class CountDownLatchTest {
    static CountDownLatch end = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> {
            System.out.println("1");
            end.countDown();
            System.out.println("2");
            end.countDown();
        }).start();

        end.await();
        System.out.println("done...");
    }
}
