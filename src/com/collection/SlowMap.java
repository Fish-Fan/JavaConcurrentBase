package com.collection;

import java.util.*;

/**
 * Created by yanfeng-mac on 2017/10/22.
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private ArrayList<K> listKey = new ArrayList<>();
    private ArrayList<V> listValue = new ArrayList<>();

    public V put(K key,V value) {
        V oldValue = null;

        if(listKey.contains(key)) {
            oldValue = listValue.get(listKey.indexOf(key));
            listValue.set(listKey.indexOf(key),value);
        } else {
            listKey.add(key);
            listValue.add(value);
        }
        return oldValue;
    }

    public V get(Object key) {
        if(!listKey.contains(key))
            return null;
        else {
            return listValue.get(listKey.indexOf(key));
        }
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        Iterator<K> keyIterator = listKey.iterator();
        Iterator<V> valueIterator = listValue.iterator();
        while (keyIterator.hasNext()) {
            set.add(new MapEntry<>(keyIterator.next(),valueIterator.next()));
        }
        return set;

    }
//    private List<K> listKeys = new ArrayList<>();
//    private List<V> listValues = new ArrayList<>();
//
//    public V put(K key,V value) {
//        V oldValue = get(key);
//        if(listKeys.contains(key)) {
//            listValues.set(listKeys.indexOf(key),value);
//        } else {
//            listKeys.add(key);
//            listValues.add(value);
//        }
//
//        return oldValue;
//    }
//
//    public V get(Object key) {
//        if(listKeys.contains(key)) {
//            return listValues.get(listKeys.indexOf(key));
//        }else {
//            return null;
//        }
//    }
//
//
//    @Override
//    public Set<Map.Entry<K, V>> entrySet() {
//
//        Set<Map.Entry<K,V>> set = new HashSet<>();
//        Iterator<K> iteratorKey = listKeys.iterator();
//        Iterator<V> iteratorValue = listValues.iterator();
//
//        while (iteratorKey.hasNext()) {
//            set.add(new MapEntry<K,V>(iteratorKey.next(), iteratorValue.next()));
//        }
//
//        return set;
//    }
}
