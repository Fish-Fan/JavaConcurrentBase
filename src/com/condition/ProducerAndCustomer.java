package com.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanfeng-mac on 2017/11/18.
 */
public class ProducerAndCustomer {
    public static Lock lock = new ReentrantLock(true);
    public static Condition notFull = lock.newCondition();
    public static Condition notEmpty = lock.newCondition();

    public static int totalProduce = 10;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int containerMaxCp = 3;

    public static AtomicInteger generatorPro = new AtomicInteger(0);

    static class Producer implements Runnable {
        static volatile int hasProduceCount = 0;

        public void run() {


            while (true) {
                lock.lock();
                try {
                    while (list.size() >= containerMaxCp) {
                        notFull.await();
                    }

                    if(hasProduceCount == totalProduce) {
                        System.out.println("task has finished...");
                        return;
                    } else {
                        list.add(generatorPro.incrementAndGet());
                        System.out.println(Thread.currentThread().getName() + " product " + generatorPro.get());
                        notEmpty.signal();
                        hasProduceCount++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }


        }
    }

    static class Customer implements Runnable {
        static volatile int hasConsumerCount = 0;

        public void run() {

            while (true) {
                lock.lock();
                try {
                    while (list.size() == 0) {
                        notEmpty.await();
                    }

                    int a = list.remove(0);
                    hasConsumerCount++;
                    System.out.println(Thread.currentThread().getName() + " consumer " + a);
                    notFull.signal();

                    if(hasConsumerCount == totalProduce) {
                        System.out.println("All product has  benn consumer...");
                        return;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }

        }
    }

    public static void main(String[] args) {
        Thread p1 = new Thread(new Producer(), "p-1");
        Thread p2 = new Thread(new Producer(), "p-2");
        Thread p3 = new Thread(new Producer(), "p-3");

        Thread c1 = new Thread(new Customer(),"c-1");
        Thread c2 = new Thread(new Customer(), "c-2");
        Thread c3 = new Thread(new Customer(), "c-3");

//        ExecutorService exec = Executors.newFixedThreadPool(3);
//
//        exec.execute(c1);
//        exec.execute(c2);
//        exec.execute(c3);
//        exec.execute(p1);
//        exec.execute(p2);
//        exec.execute(p3);

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        try{
            c1.join();
            c2.join();
            c3.join();
            p1.join();
            p2.join();
            p3.join();
        }catch(Exception e){

        }
        System.out.println(" done. ");
    }
}
