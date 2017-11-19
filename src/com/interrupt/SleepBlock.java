package com.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanfeng-mac on 2017/11/19.
 */
public class SleepBlock implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Interrupt Exception");
        }

        System.out.println("Exiting SleepBlock.run()");
    }
}
