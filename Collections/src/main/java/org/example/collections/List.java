package org.example.collections;

public interface List <E>{
    public void add (E data);
    public void removeAll ();
    public void remove(E data);
    public void setAt (int position, E newData);
    public E getAt(int position);
    public int size ();
    public Iterator<E> iterator();
}
