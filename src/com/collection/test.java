package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanfeng-mac on 2017/10/23.
 */
public class test {
    public static void main(String[] args) {
//        Map<String,String> maps = new HashMap<>();
//        SlowMap<String,String> maps = new SlowMap<>();
        SimpleHashMap<String,String> maps = new SimpleHashMap<>();
        maps.put("1","大象");
        maps.put("2","老虎");
        maps.put("3","狮子");
        maps.put("4","鬣狗");

//        Map.Entry entry = (Map.Entry) maps.entrySet();
        Set<Map.Entry<String, String>> sets = maps.entrySet();

        maps.put("1","哈士奇");
        System.out.println("sets->" + sets);

        System.out.println("get(2)->" + maps.get("2"));

        maps.remove("3");

        System.out.println("maps->" + maps);
    }
}
