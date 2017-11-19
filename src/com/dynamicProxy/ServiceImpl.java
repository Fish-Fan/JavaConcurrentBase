package com.dynamicProxy;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class ServiceImpl implements Service {
    @Override
    public void add() {
        System.out.println("This is serviceimpl");
    }
}
