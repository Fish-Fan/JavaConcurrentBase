package com.thread;

/**
 * Created by yanfeng-mac on 2017/11/1.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run() {
            try {
                sleep(10);
                while (!ready) {
                    Thread.yield();
                }
                System.out.println(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        int i = 100;
//        while (i-- > 0) {
//
//        }
        new ReaderThread().start();
        ready = true;
        number = 42;
    }
}
