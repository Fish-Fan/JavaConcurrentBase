package com.collection;

import java.util.Random;

/**
 * Created by yanfeng-mac on 2017/10/22.
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    public String toString() {
        if(shadow) {
            return "夏天";
        }else {
            return "冬天";
        }
    }
}
