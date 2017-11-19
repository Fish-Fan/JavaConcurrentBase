package com.staticProxy;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject!!!");
    }
}
