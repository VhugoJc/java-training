package org.example.collections;

public interface List <T>{
     void add (T data);
     void removeAll ();
     void remove(T data) ;
     void setAt (int position, T newData);
     T getAt(int position);
     int size ();
     Iterator<T> iterator();
}
