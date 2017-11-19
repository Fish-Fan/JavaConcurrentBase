package com.thread;

import java.util.Arrays;

/**
 * Created by yanfeng-mac on 2017/10/31.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber--;
    }
}

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for(int i = 0;i < size;i++) {
            array[i] = -1;
        }

        System.out.println(Arrays.toString(array));
    }

    public synchronized void add(int i) {
        array[index] = 1;
        index = ++index % len;
    }

    public synchronized boolean contains (int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) return true;
        }

        return false;
    }
}
