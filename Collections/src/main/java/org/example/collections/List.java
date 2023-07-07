package org.example.collections;

public interface List {
    public void add (int data);
    public void removeAll ();
    public void remove(int data);
    public void setAt (int position, int newData);
    public Integer getAt(int position);
    public int size ();
    public Iterator iterator();
}
