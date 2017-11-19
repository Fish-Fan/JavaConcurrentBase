package com.company;

/**
 * Created by yanfeng-mac on 2017/10/11.
 */
public class OuterClass {
    private int i;
    public OuterClass(int num) {
        i = num;
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private class InnerClass implements InterfaceA{
        public void innerSetI(int num) {
            i = num;
        }

        public int innerGetI() {
            return i;
        }

        @Override
        public int fun() {
            System.out.println("haha");
            return 0;
        }
    }
}
