package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanfeng-mac on 2017/11/4.
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepThread(),"SleepThread");
        Thread busyThread = new Thread(new BusyThread(),"BusyThread");

        sleepThread.setDaemon(true);
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class  BusyThread implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
