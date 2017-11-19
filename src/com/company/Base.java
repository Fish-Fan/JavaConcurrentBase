package com.company;

/**
 * Created by yanfeng-mac on 2017/10/20.
 */
public class Base {
    private String baseName = "base";
    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        public Sub() {
            super();
        }

        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base base = new Sub();
    }
}
