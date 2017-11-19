package com.company;

import java.util.SortedSet;

/**
 * Created by yanfeng-mac on 2017/10/20.
 */
public class TreeSet {
    public static void main(String[] args) {
        SortedSet<String> sortedSets = new java.util.TreeSet<>();
        sortedSets.add("tom");
        sortedSets.add("jenny");
        sortedSets.add("alice");

        for(String s : sortedSets) {
            System.out.println(s);
        }
    }
}
