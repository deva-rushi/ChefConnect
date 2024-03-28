/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chefconnect.collections;

/**
 *
 * @author rakadadevarushikamidi
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private int capacity;
    private int size;
    private Entry<K, V>[] buckets;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new Entry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : buckets) {
            if (entry != null && Objects.equals(entry.getValue(), value))
                return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = getIndex(key);
        while (buckets[index] != null) {
            if (Objects.equals(buckets[index].getKey(), key))
                return buckets[index].getValue();
            index = (index + 1) % capacity;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        ensureCapacity();

        int index = getIndex(key);
        while (buckets[index] != null) {
            if (Objects.equals(buckets[index].getKey(), key)) {
                V oldValue = buckets[index].getValue();
                buckets[index].setValue(value);
                return oldValue;
            }
            index = (index + 1) % capacity;
        }

        buckets[index] = new Entry<>(key, value);
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = getIndex(key);
        while (buckets[index] != null) {
            if (Objects.equals(buckets[index].getKey(), key)) {
                V oldValue = buckets[index].getValue();
                buckets[index] = null;
                size--;
                return oldValue;
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    @Override
    public void putAll(MyMap<? extends K, ? extends V> m) {
        for (MyMap.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }


    @Override
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (Entry<K, V> entry : buckets) {
            if (entry != null)
                keySet.add(entry.getKey());
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : buckets) {
            if (entry != null)
                values.add(entry.getValue());
        }
        return values;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> entrySet = new HashSet<>();
        for (Entry<K, V> entry : buckets) {
            if (entry != null)
                entrySet.add(entry);
        }
        return entrySet;
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void ensureCapacity() {
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            capacity *= 2;
            Entry<K, V>[] newBuckets = new Entry[capacity];
            for (Entry<K, V> entry : buckets) {
                if (entry != null) {
                    int index = getIndex(entry.getKey());
                    while (newBuckets[index] != null) {
                        index = (index + 1) % capacity;
                    }
                    newBuckets[index] = entry;
                }
            }
            buckets = newBuckets;
        }
    }

    private static class Entry<K, V> implements MyMap.Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
