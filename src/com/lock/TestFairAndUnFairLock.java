package com.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yanfeng-mac on 2017/11/10.
 */
public class TestFairAndUnFairLock {
    private static ReentrantLock2 lock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);
    public static CountDownLatch start = new CountDownLatch(1);

    public void fair() {
        testLock(lock);
    }

    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(ReentrantLock2 lock) {
        for(int i = 0;i < 5;i++) {
            Job job = new Job(lock);
            job.setName(i+ "");
            job.start();
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }

        public void run() {
            for(int i =  0;i < 2;i++) {
                try {
                    start.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    System.out.print("currentThread->" + Thread.currentThread()
                            .getName() + "   ");
                    System.out.println("queue->" + lock.getQueuedThreads());
                } finally {
                    lock.unlock();
                }
            }

        }
    }


    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> threadList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(threadList);
            return threadList;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        
        TestFairAndUnFairLock test = new TestFairAndUnFairLock();
        test.fair();
//        test.unfair();
        TimeUnit.SECONDS.sleep(1);
        TestFairAndUnFairLock.start.countDown();
    }
}
