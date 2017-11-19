package com.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by yanfeng-mac on 2017/11/9.
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        int count = sync.tryAcquireShared(1);
        if( count >= 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }


    private static class Sync extends AbstractQueuedSynchronizer {
        public Sync(int threadCounts) {
            if(threadCounts <=0 ) {
                throw new IllegalArgumentException("count must be large than zero");
            }
            setState(threadCounts);
        }

        public int tryAcquireShared(int reduceCount) {
            for(;;) {
                int current = getState();
                int balance = current - reduceCount;
                if(balance < 0 || compareAndSetState(current,balance)) {
                    return balance;
                }
            }
        }

        public boolean tryReleaseShared(int returnCount) {
            for(;;) {
                int current = getState();
                int balance = current + returnCount;
                if(compareAndSetState(current,balance)) {
                    return true;
                }
            }
        }

    }



}
