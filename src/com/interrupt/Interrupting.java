package com.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanfeng-mac on 2017/11/19.
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> future = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        future.cancel(true);
        System.out.println("Interrupt send to " + r.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        //test(new SleepBlock());
        test(new IOBlocked(System.in));
    }
}
