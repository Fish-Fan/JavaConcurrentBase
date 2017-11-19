package com.collection;

/**
 * Created by yanfeng-mac on 2017/10/22.
 */
public class Groundhog {
    protected int number;
    public Groundhog(int n) {
        number = n;
    }

    @Override
    public String toString() {
        return "Groundhog#" + number;
    }

    public boolean equals(Object o) {
        return o instanceof Groundhog && (number == ((Groundhog) o).number);
    }

    public int hashCode() {
        return number;
    }
}
