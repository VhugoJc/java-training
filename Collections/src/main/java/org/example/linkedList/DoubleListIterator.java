package org.example.linkedList;

import java.util.Iterator;

public class DoubleListIterator implements Iterator<DoubleNode> {
    private DoubleNode list;

    public DoubleListIterator(DoubleNode list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list!=null;
    }

    @Override
    public DoubleNode next() {
        DoubleNode current = list;
        list = list.getNext();
        return current;
    }
}
