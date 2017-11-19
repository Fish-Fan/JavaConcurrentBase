package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class ThreadLocalTest {
//    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
//        protected Long initialValue() {
//            return System.currentTimeMillis();
//        }
//    };

    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(() ->
         System.currentTimeMillis()
    );

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final Long end() {
        return (System.currentTimeMillis() - TIME_THREADLOCAL.get());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(ThreadLocalTest.end());
    }
}
