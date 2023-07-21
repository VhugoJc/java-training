package org.example.collections;

public interface List <T>{
    public void add (T data);
    public void removeAll ();
    public void remove(T data) throws NotNullAllowedException;
    public void setAt (int position, T newData);
    public T getAt(int position);
    public int size ();
    public Iterator<T> iterator();
}
