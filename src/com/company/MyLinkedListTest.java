package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * Created by yanfeng-mac on 2017/10/19.
 */
public class MyLinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Tom");
        linkedList.add("Marry");
        linkedList.add("Bob");

        ListIterator<String> iter = linkedList.listIterator();
        iter.next();
        iter.next();

        iter.previous();
        iter.remove();

        for(String str: linkedList) {
            System.out.println(str);
        }


    }
}
