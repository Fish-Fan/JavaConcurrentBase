package com.connectionPool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    //保证所有线程同时开始获取连接
    static CountDownLatch start = new CountDownLatch(1);
    //保证所有线程执行完毕之后在执行main线程
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 50;
        end = new CountDownLatch(threadCount);

        //每个线程尝试获取数据库连接的次数
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for(int i = 0;i < threadCount;i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnableThread");
            thread.start();
        }
        //所有线程开始执行
        start.countDown();
        //main线程等待所有线程执行完毕
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                //所有线程刚开始运行时都为Block状态，直到start为0时，所有线程开始同步执行
                start.await();
//                System.out.println("currentThread->" + Thread.currentThread() + " currentTime->" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            //当某个线程执行完毕时，进入block状态，知道end为0，开始执行main线程
            end.countDown();
        }
    }
}
