package com.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by yanfeng-mac on 2017/11/4.
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);

        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();

        int recive = 0;

        try {
            while ((recive = in.read()) != '.') {
                System.out.println(recive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int recive = 0;
            try {
                while ((recive = in.read()) != '.') {
                    System.out.println((char)recive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
