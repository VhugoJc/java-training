package org.example.linkedList;

import java.util.Iterator;

public class DoubleListIterator implements Iterator<DoubleNode> {
    private DoubleNode node;

    public DoubleListIterator(DoubleNode head) {
        this.node = head;
    }

    @Override
    public boolean hasNext() {
        return node!=null;
    }

    @Override
    public DoubleNode next() {
        DoubleNode current = node;
        node = node.getNext();
        return current;
    }
}
