package com.concurrentutil;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by yanfeng-mac on 2017/11/13.
 */
public class CyclicBarrierService implements Runnable{
    private CyclicBarrier c = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankResult = new ConcurrentHashMap<>();

    //当count方法里面的4个线程执行完毕之后，执行this.run();
    private void count() {
        for(int i = 0;i < 4;i++) {
            executor.execute(() -> {
                sheetBankResult.put(Thread.currentThread().getName(),123);
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for(Map.Entry<String,Integer> sheet : sheetBankResult.entrySet()) {
            result += sheet.getValue();
        }

        sheetBankResult.put("result",result);
        System.out.println("result->" + result);
    }

    public static void main(String[] args) {
        CyclicBarrierService cyclicBarrierService = new CyclicBarrierService();
        cyclicBarrierService.count();
    }
}
