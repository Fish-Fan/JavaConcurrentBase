package com.company;

import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);

        System.out.println("------------");

        Collections.fill(list,new StringAddress("World"));
        System.out.println(list);

        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
//        Object o = new Object();
//        o.equals();

        
    }
}
