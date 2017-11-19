package com.company;

/**
 * Created by yanfeng-mac on 2017/10/9.
 */
public class ClassA extends Father implements InterfaceA {
    @Override
    public int fun() {
        System.out.println("111");
        return 0;
    }
}
