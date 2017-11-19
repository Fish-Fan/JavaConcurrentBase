package com.company;

import java.util.Comparator;

/**
 * Created by yanfeng-mac on 2017/10/9.
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first,String second) {
        return first.length() - second.length();
    }

}
