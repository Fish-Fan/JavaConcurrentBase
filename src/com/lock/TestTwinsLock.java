package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by yanfeng-mac on 2017/11/9.
 */
public class TestTwinsLock {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new TwinsLock();
        CountDownLatch start = new CountDownLatch(1);
        //CountDownLatch end = new CountDownLatch(1);

        class Work extends Thread {
            public void run() {
                while (true) {
                    try {
                        start.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        System.out.println("release lock...");

                    }
                }
            }
        }

        for(int i = 0;i < 10;i++) {
            Work work = new Work();
            work.start();
        }

        start.countDown();

        for(int i = 0; i <10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        //end.await();
        //System.out.println("finished...");

    }
}
