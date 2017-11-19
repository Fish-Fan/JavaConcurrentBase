package com.company;

/**
 * Java运算符优先级
 * Created by yanfeng-mac on 2017/10/6.
 */
public class Test{
    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x;
    }
}
