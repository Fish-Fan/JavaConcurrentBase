package com.company;

/**
 * Created by yanfeng-mac on 2017/10/22.
 */
public class StringAddress {
    private String s;
    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
