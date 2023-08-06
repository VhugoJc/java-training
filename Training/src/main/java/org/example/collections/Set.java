package org.example.collections;

public interface Set <E>{
    void add(E element);
    void remove(E element);
    void removeAll(); //clear
    int size();
    Boolean contains (E element);
    Iterator<E> iterator();
}
