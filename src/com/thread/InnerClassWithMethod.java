package com.thread;

import java.util.concurrent.TimeUnit;

import static sun.jvm.hotspot.runtime.PerfMemory.initialized;
import static sun.jvm.hotspot.runtime.PerfMemory.start;

/**
 * Created by yanfeng-mac on 2017/10/30.
 */
public class InnerClassWithMethod {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").executeTask();
    }

}

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if(--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

class InnerThread2 {
    private int coutDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if(--coutDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return getName() + ": " + coutDown;
            }
        };

        t.start();

    }
}

class InnerRunnable1 {
    private int coutDown = 5;
    private Thread t;
    private Inner inner;
    private class Inner implements Runnable{
        public Inner(String name) {
            t = new Thread(this,name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--coutDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return t.getName() + ": " + coutDown;
        }
    }

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

class InnerRunnable2 {
    private int coutDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if(--coutDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return t.getName() + ": " + coutDown;
            }
        };
        t.start();
    }
}

class ThreadMethod {
    private int coutDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void executeTask() {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if(--coutDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return t.getName() + ": " + coutDown;
            }
        };

        t.start();
    }
}
