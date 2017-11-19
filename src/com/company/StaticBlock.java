package com.company;

/**
 * 静态块初始化
 * Created by yanfeng-mac on 2017/10/8.
 */
public class StaticBlock {
    public static StaticBlock t1 = new StaticBlock();
    public static StaticBlock t2 = new StaticBlock();
    {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        StaticBlock t = new StaticBlock();
    }
}
