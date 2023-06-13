package org.example.linkedList;

public interface LinkedList {
    public void add (int data);
    public void removeAll ();
    public void remove(int data);
    public void remove();
    public void setAt (int position, int newData);
    public Integer getAt(int position);
    public int size ();
}
