package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanfeng-mac on 2017/10/20.
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> sets = new HashSet<>(3);

        sets.add("tom");
        sets.add("abnny");
        sets.add("alice");

        for(String s : sets) {
            System.out.println(s);
        }
    }
}
