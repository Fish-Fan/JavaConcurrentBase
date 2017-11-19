package com.company;

import java.util.*;
import java.util.TreeSet;

/**
 * Created by yanfeng-mac on 2017/10/20.
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> sets = new HashSet<>();
        Set<String> strings = new TreeSet<>();
        sets.add("tom");
        sets.add("jenny");
        sets.add("alice");

        System.out.println(sets);

    }
}
