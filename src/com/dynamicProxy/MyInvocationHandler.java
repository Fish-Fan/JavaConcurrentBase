package com.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---before---");
        System.out.println("Method->" + method);
        Object result = method.invoke(target,args);
        System.out.println("---after---");
        return result;
    }

    public Object getProxy() {
        ClassLoader classLoader = ServiceImpl.class.getClassLoader();
        System.out.println("CurrentThreadName->" + ServiceImpl.class.getClassLoader());
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(service);
        Service proxy = (Service) invocationHandler.getProxy();
        proxy.add();
    }
}
