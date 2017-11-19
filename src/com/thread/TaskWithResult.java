package com.thread;

import java.util.concurrent.Callable;

/**
 * Created by yanfeng-mac on 2017/10/26.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        return "This result is " + id;
    }
}
