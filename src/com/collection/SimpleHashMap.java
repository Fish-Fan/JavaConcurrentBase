package com.collection;

import java.util.*;

/**
 * Created by yanfeng-mac on 2017/10/23.
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int size = 100;

    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[size];

    public V put(K key,V value) {
        int index = Math.abs(key.hashCode()) % size;

        if(buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }

        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        ListIterator<MapEntry<K,V>> iterator = bucket.listIterator();

        V oldValue = null;
        boolean found = false;

        MapEntry<K,V> pair = new MapEntry<>(key,value);

        while (iterator.hasNext()) {
            MapEntry<K,V> item = iterator.next();
            if(item.getKey().equals(key)) {
                oldValue = item.getValue();
                found = true;
                item.setValue(value);
                break;
            }
        }

        if(!found) {
            bucket.add(pair);
        }

        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % size;
        LinkedList<MapEntry<K,V>> bucket = buckets[index];

        if(buckets[index] == null) {
            return null;
        } else {
            for(MapEntry<K,V> item : bucket) {
                if(item.getKey().equals(key)) {
                    return item.getValue();
                }
            }
        }

        return null;
    }

    public V remove(Object key) {
        V oldValue = null;
        int index = key.hashCode();

        if(buckets[index] == null)
            return null;
        else {
            for(MapEntry<K,V> item : buckets[index]) {
                if(item.getKey().equals(key)) {
                    oldValue = item.getValue();
                    buckets[index].remove(item);
                    return oldValue;
                }
            }
        }
        return oldValue;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if( bucket == null)
                continue;
            for(MapEntry<K,V> item : bucket) {
                set.add(item);
            }
        }

        return set;
    }
}
