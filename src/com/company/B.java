package com.company;

/**
 * Created by yanfeng-mac on 2017/10/8.
 */
public class B {
    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态块");
    }
    public B() {
        System.out.println("构造函数");
    }
}
