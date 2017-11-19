package com.staticProxy;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }
    @Override
    public void request() {
        System.out.println("before");
        subject.request();
        System.out.println("after");
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy p = new Proxy(realSubject);
        p.request();
    }
}
