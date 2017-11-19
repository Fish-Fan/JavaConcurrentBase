package com.concurrentutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by yanfeng-mac on 2017/11/13.
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3,() -> {
        System.out.println("get the barrier state!!!");
    });

    public static void main(String[] args) {

        for(int i = 0;i < 3;i++) {
            if(i < 2) {
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "正在进行写操作...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        c.await(2000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                    System.out.println("所有操作执行完毕，" + Thread.currentThread().getName() + "继续执行其他操作...");

                }).start();
            } else {
                try {
                    Thread.sleep(5000);
                    new Thread(() -> {
                        System.out.println(Thread.currentThread().getName() + "正在进行写操作...");
                        try {
                            c.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                        System.out.println("所有操作执行完毕，" + Thread.currentThread().getName() + "继续执行其他操作...");
                    }).start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
