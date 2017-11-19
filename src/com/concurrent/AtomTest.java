package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanfeng-mac on 2017/11/2.
 */
public class AtomTest {
    private AtomicInteger i;

    public AtomTest(AtomicInteger i) {
        this.i = i;
    }

    public AtomicInteger getI() {
        return i;
    }

    public void setI(AtomicInteger i) {
        this.i = i;
    }

    public static void main(String[] args) {

    }
}
