package com.interrupt;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yanfeng-mac on 2017/11/19.
 */
public class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream in) {this.in = in;}
    @Override
    public void run() {
        System.out.println("waiting for read: ");
        try {
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from IOBlocked");
            } else {
                throw new RuntimeException();
            }
        }

        System.out.println("Exiting from IOBlocked.run()");
    }
}
