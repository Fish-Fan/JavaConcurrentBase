package com.collection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanfeng-mac on 2017/10/22.
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);

        Map<Groundhog,Prediction> map = new HashMap<>();

        for(int i = 0;i < 10;i++) {
            map.put(new Groundhog(i),new Prediction());
        }

        System.out.println(map);

        Groundhog groundhog = ghog.newInstance(3);
        System.out.println("groundhog.hascode-> " + groundhog.hashCode() + " " + groundhog);

        if(map.containsKey(groundhog)) {
            System.out.println("find it");
        } else {
            System.out.println("have not found");
        }

    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}
