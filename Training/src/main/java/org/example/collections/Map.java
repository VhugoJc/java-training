package org.example.collections;

public interface Map<K, V>{
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    void removeAll(); //clear
    int size();
    boolean containsKey (K key);
    Iterator<V> iterator();
}
