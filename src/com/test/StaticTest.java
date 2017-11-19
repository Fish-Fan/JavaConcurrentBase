package com.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class StaticTest {

    public static void main(String[] args) {
        int a = 10;
        System.out.println("a >>> 2 = " + (a >>> 2));
        System.out.println("a << 2 = " + (a << 2));
    }
}
