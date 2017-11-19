package com.company;

/**
 * Created by yanfeng-mac on 2017/10/8.
 */
public class BB extends B {
    {
        System.out.println("代码块BB");
    }
    static {
        System.out.println("静态块BB");

    }
    public BB() {
        System.out.println("构造函数BB");
    }


    public static void main(String[] args) {

    }

    static {
        System.out.println("------------");
        new BB();
    }
}
