package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by yanfeng-mac on 2017/10/11.
 */
public class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object t) {
        target = t;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        System.out.println(Arrays.toString(args));

        return method.invoke(target,args);
    }
}
